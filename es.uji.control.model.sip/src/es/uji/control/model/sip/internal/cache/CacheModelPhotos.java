package es.uji.control.model.sip.internal.cache;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import es.uji.control.commons.diskcache.DiskCacheException;
import es.uji.control.commons.diskcache.ICacheEntry;
import es.uji.control.commons.diskcache.IDiskCache;
import es.uji.control.domain.people.IPhoto;
import es.uji.control.domain.provider.service.connectionfactory.ControlConnectionException;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnection;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnectionFactory;
import es.uji.control.domain.provider.subsystem.people.IPersonService;
import es.uji.control.domain.provider.subsystem.people.IPhotoStream;
import es.uji.control.model.sip.ModelLogEntry;
import es.uji.control.model.sip.ModelLogSource;
import es.uji.control.model.sip.ModelLogType;

public class CacheModelPhotos {

	static public class CacheFactoryBuilder {
		
		final private IControlConnectionFactory controlConnectionFactory;
		final private IDiskCache diskCache;
		final private Consumer<ModelLogEntry> consumer;
		
		public CacheFactoryBuilder(IControlConnectionFactory controlConnectionFactory, IDiskCache diskCache, Consumer<ModelLogEntry> consumer) {
			this.controlConnectionFactory = controlConnectionFactory;
			this.diskCache = diskCache;
			this.consumer = consumer;
		}
		
		public CacheModelPhotos build() throws CacheModelPhotosException {
			try {
				return new CacheModelPhotos(controlConnectionFactory.createConnection(), diskCache, consumer);
			} catch (ControlConnectionException e) {
				throw new CacheModelPhotosException("Imposible obtener una nueva conexion con el backend.", e.getCause());
			}
			
		}
	}
	

	static public CacheFactoryBuilder newCacheFactoryBuilder(IControlConnectionFactory controlConnectionFactory, IDiskCache diskCache, Consumer<ModelLogEntry> consumer) {
		return new CacheFactoryBuilder(controlConnectionFactory, diskCache, consumer);
	}
	
	final private Consumer<ModelLogEntry> consumer;
	final private IDiskCache diskCache;
	
	public CacheModelPhotos(IControlConnection controlConnection, IDiskCache diskCache, Consumer<ModelLogEntry> consumer) throws CacheModelPhotosException {
	
		this.diskCache = diskCache;
		this.consumer = consumer;
		
		try {
			IPersonService personService = controlConnection.getPersonService();
			updatePhotos(personService);
		} catch (ControlConnectionException e) {
			throw new CacheModelPhotosException("No se puede obtener el servicio para acceder al subsistema 'Person'", e);
		} 
		
	}
	
	private void updatePhotos(IPersonService personService) throws CacheModelPhotosException {
		
		try {
			personService.getAllPhotos(new IPhotoStream() {
				
				int numPhotos = 0;
				ICacheEntry cacheEntry = null;
				byte[] cacheEntryBytes = null;
				Date cacheEntryTimestamp = null;
				
				@Override
				public void onNext(List<IPhoto> photos) {
					
					int size = photos.size();
					
					for (IPhoto photo : photos) {
						
						long identifier = photo.getPersonIdentifier().getId();
						Date timestamp = Date.from(photo.getDate().atZone(ZoneId.systemDefault()).toInstant());
						byte[] image = photo.getImage();
						
						try {
							cacheEntry = diskCache.getEntry(identifier);
						} catch (DiskCacheException dcEx) {
							consumer.accept(new ModelLogEntry(Instant.now(), ModelLogSource.PHOTOS, ModelLogType.ERROR, String.format("No se ha podido obtener la entrada para el perId indicado")));
						}
						
						if (cacheEntry != null) {
							try {
								cacheEntryBytes = cacheEntry.getBytes();
								cacheEntryTimestamp = cacheEntry.getTimestamp();
								if (cacheEntryBytes == null || cacheEntryTimestamp == null || cacheEntryTimestamp.compareTo(timestamp) < 0) {
									try {
										diskCache.addEntry(identifier, timestamp, image);
									} catch (DiskCacheException dcEx) {
										consumer.accept(new ModelLogEntry(Instant.now(), ModelLogSource.PHOTOS, ModelLogType.ERROR, String.format("No se ha podido persistir la entrada en disco")));
									}
								}
							} catch (DiskCacheException dcEx) {
								consumer.accept(new ModelLogEntry(Instant.now(), ModelLogSource.PHOTOS, ModelLogType.ERROR, String.format("No se han podido obtener los parametros de la entrada")));
							}	
						} else {
							try {
								diskCache.addEntry(identifier, timestamp, image);
							} catch (DiskCacheException dcEx) {
								consumer.accept(new ModelLogEntry(Instant.now(), ModelLogSource.PHOTOS, ModelLogType.ERROR, String.format("No se ha podido persistir la entrada en disco")));
							}
						}						
					}
					
					numPhotos = numPhotos + size;
					consumer.accept(new ModelLogEntry(Instant.now(), ModelLogSource.PHOTOS, ModelLogType.INFO, String.format("%d Fotos cargadas", numPhotos)));
					
				}
				
				@Override
				public void onError(Throwable t) {
					consumer.accept(new ModelLogEntry(Instant.now(), ModelLogSource.PHOTOS, ModelLogType.ERROR, String.format("Error duranle la carga (%s).", t.getMessage())));
				}
				
				@Override
				public void onCompleted() {
					consumer.accept(new ModelLogEntry(Instant.now(), ModelLogSource.PHOTOS, ModelLogType.INFO, String.format("%d fotos cargadas correctamente.", numPhotos)));
				}
			});
		} catch (ControlConnectionException e) {
			throw new CacheModelPhotosException("Han surgido problemas con la conexion durante la carga de las fotos.", e);
		}
		
	}
	
}
