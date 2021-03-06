package es.uji.control.model.sip.internal.cache;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

import es.uji.control.commons.diskcache.DiskCacheException;
import es.uji.control.commons.diskcache.ICacheEntry;
import es.uji.control.commons.diskcache.IDiskCache;
import es.uji.control.domain.people.IPersonIdentifier;
import es.uji.control.domain.people.IPhoto;
import es.uji.control.domain.people.PersonIdentifierType;
import es.uji.control.domain.people.PhotoBuilder;
import es.uji.control.domain.provider.service.connectionfactory.ControlConnectionException;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnection;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnectionFactory;
import es.uji.control.domain.provider.subsystem.people.IPersonService;
import es.uji.control.domain.provider.subsystem.people.IPhotoStream;
import es.uji.control.model.sip.ModelLogEntry;
import es.uji.control.model.sip.ModelLogSource;
import es.uji.control.model.sip.ModelLogType;

public class CacheModelPhotos {

	static final UUID SIGNATURE = UUID.fromString("eed74942-943c-11e5-8994-feff819cdc9f");
	
	static public class CacheConnectionFactoryBuilder {
		
		final private IControlConnectionFactory controlConnectionFactory;
		final private IDiskCache diskCache;
		final private Consumer<ModelLogEntry> consumer;
		
		public CacheConnectionFactoryBuilder(IControlConnectionFactory controlConnectionFactory, IDiskCache diskCache, Consumer<ModelLogEntry> consumer) {
			this.controlConnectionFactory = controlConnectionFactory;
			this.diskCache = diskCache;
			this.consumer = consumer;
		}
		
		public CacheModelPhotos build() throws CacheModelPhotosException {
			try {
				if (controlConnectionFactory.getSignature().equals(SIGNATURE)) {
					return new CacheModelPhotos(controlConnectionFactory.createConnection(), diskCache, consumer);
				} else {
					throw new CacheModelPhotosException("La firma de la conexión no es valida.");
				}
			} catch (ControlConnectionException e) {
				throw new CacheModelPhotosException("Imposible obtener una nueva conexion con el backend.", e.getCause());
			}
			
		}
	}

	static public CacheConnectionFactoryBuilder newCacheConnectionFactoryBuilder(IControlConnectionFactory controlConnectionFactory, IDiskCache diskCache, Consumer<ModelLogEntry> consumer) {
		return new CacheConnectionFactoryBuilder(controlConnectionFactory, diskCache, consumer);
	}
	
	static public class CacheFactoryBuilder {
		
		final private IDiskCache diskCache;
		final private Consumer<ModelLogEntry> consumer;
		
		public CacheFactoryBuilder(IDiskCache diskCache, Consumer<ModelLogEntry> consumer) {
			this.diskCache = diskCache;
			this.consumer = consumer;
		}
		
		public CacheModelPhotos build() throws CacheModelPhotosException {
			return new CacheModelPhotos(diskCache, consumer);
		}
	}

	static public CacheFactoryBuilder newCacheFactoryBuilder(IDiskCache diskCache, Consumer<ModelLogEntry> consumer) {
		return new CacheFactoryBuilder(diskCache, consumer);
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
	
	public CacheModelPhotos(IDiskCache diskCache, Consumer<ModelLogEntry> consumer) throws CacheModelPhotosException {
		this.diskCache = diskCache;
		this.consumer = consumer;
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
	
	public IPhoto getPhotoById(IPersonIdentifier personIdentifier) throws CacheModelPhotosException {
		try {
			ICacheEntry entry = diskCache.getEntry(PersonIdentifierType.bytesToGeneralLongId(personIdentifier.getRaw()));
			
			if (entry == null) {
				throw new CacheModelPhotosException("No se ha podido obtener la foto.");
			}
			
			byte[] bytes = entry.getBytes();
			LocalDateTime timestamp = LocalDateTime.ofInstant(Instant.ofEpochMilli(entry.getTimestamp().getTime()), ZoneId.systemDefault());
			
			if (bytes != null && timestamp != null) {
				return new PhotoBuilder()
						.setPersonId(personIdentifier)
						.setImage(bytes)
						.setDate(timestamp)
						.build();
			} else {
				throw new CacheModelPhotosException("La imagen se encuentra vacia.");
			}
		} catch (DiskCacheException e) {
			throw new CacheModelPhotosException("No se ha podido obtener la foto.", e);
		}
	}
	
}
