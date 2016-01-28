/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.sip.internal;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import es.uji.control.commons.diskcache.IDiskCache;
import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.IPerson;
import es.uji.control.domain.people.IPersonIdentifier;
import es.uji.control.domain.people.IPhoto;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnectionFactory;
import es.uji.control.model.sip.IModel;
import es.uji.control.model.sip.ModelException;
import es.uji.control.model.sip.ModelLogEntry;
import es.uji.control.model.sip.ModelLogSource;
import es.uji.control.model.sip.ModelLogType;
import es.uji.control.model.sip.ModelStatus;
import es.uji.control.model.sip.internal.cache.CacheModelPhotos;
import es.uji.control.model.sip.internal.cache.CacheModelPhotosException;
import es.uji.control.model.sip.internal.emf.EMFModelWrapper;
import es.uji.control.model.sip.internal.emf.EMFModelWrapperException;

@Component(name = "model.sip.component", immediate = true)
public class ModelSIPComponent implements IModel {

	private IControlConnectionFactory controlConnectionFactory;
	
	private IDiskCache diskCache;

	private EMFModelWrapper modelWrapper;
	
	private CacheModelPhotos cacheModelPhotos;

	volatile private Consumer<ModelLogEntry> logger;

	volatile private Consumer<Boolean> modelUpdating;

	volatile private Consumer<ModelStatus> state;

	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	private ReentrantReadWriteLock rwlC = new ReentrantReadWriteLock();

	private Thread updateModelThreadFromBackend;
	
	private Thread updateModelThreadFromCache;
	
	private Thread updatePhotosThread;

	private Consumer<Boolean> photosUpdating;
	
	@Activate
	public void activate() {
	}

	@Deactivate
	public void deactivate() {
	}

	@Reference(policy = ReferencePolicy.DYNAMIC, cardinality = ReferenceCardinality.OPTIONAL, name = "controlConnectionFactory")
	public void bindConnectionFactorySPI(IControlConnectionFactory controlConnectionFactory, Map<String, ?> properties) {
		synchronized (this) {
			this.controlConnectionFactory = controlConnectionFactory;
			
			checkModelUpdatingStatus();
			checkPhotosUpdatingStatus();
		}
	}

	public void unbindConnectionFactorySPI(IControlConnectionFactory controlConnectionFactory, Map<String, ?> properties) {
		synchronized (this) {
			this.controlConnectionFactory = null;
			checkModelUpdatingStatus();
			checkPhotosUpdatingStatus();
		}
	}
	
	@Reference(policy = ReferencePolicy.DYNAMIC, cardinality = ReferenceCardinality.OPTIONAL, name = "diskCache")
	public void bindDiskCache(IDiskCache diskCache, Map<String, ?> properties) {
		synchronized (this) {
			this.diskCache = diskCache;
		}
	}

	public void unbindDiskCache(IDiskCache diskCache, Map<String, ?> properties) {
		synchronized (this) {
			this.diskCache = null;
		}
	}
	
	/////////////////////////////////////////////////////////////
	// Logger
	/////////////////////////////////////////////////////////////

	@Override
	public void setLogger(Consumer<ModelLogEntry> logger) {
		this.logger = logger;
	}

	private void sendLogEntry(ModelLogEntry event) {
		Consumer<ModelLogEntry> localConsumer = this.logger;
		if (localConsumer != null) {
			localConsumer.accept(event);
		}
	}

	private void sendModelPersonLogEntry(ModelLogType type, String msg) {
		Consumer<ModelLogEntry> localConsumer = this.logger;
		if (localConsumer != null) {
			ModelLogEntry entry = new ModelLogEntry(Instant.now(), ModelLogSource.PERSONS, type, msg);
			localConsumer.accept(entry);
		}
	}
	
	private void sendModelPhotoLogEntry(ModelLogType type, String msg) {
		Consumer<ModelLogEntry> localConsumer = this.logger;
		if (localConsumer != null) {
			ModelLogEntry entry = new ModelLogEntry(Instant.now(), ModelLogSource.PHOTOS, type, msg);
			localConsumer.accept(entry);
		}
	}

	/////////////////////////////////////////////////////////////
	// Metodos que controlan el modelo
	/////////////////////////////////////////////////////////////

	private void sendModelUpdatingStatus(boolean updating) {
		Consumer<Boolean> localModelUpdating = modelUpdating;
		if (localModelUpdating != null) {
			localModelUpdating.accept(updating);
		}
	}
	
	private void checkModelUpdatingStatus() {
		if (updateModelThreadFromBackend == null && updateModelThreadFromCache == null && controlConnectionFactory != null) {
			sendModelUpdatingStatus(false);
		} else {
			sendModelUpdatingStatus(true);
		}
	}

	@Override
	public void setUpdateModelUpdatingTracker(Consumer<Boolean> modelUpdating) {
		this.modelUpdating = modelUpdating;
		try {
			rwl.writeLock().lock();
			checkModelUpdatingStatus();
		} finally {
			rwl.writeLock().unlock();
		}
	}

	@Override
	public void updateModelFromBackend() {
		synchronized (this) {
			// Se ejecuta la carga de la cache
			executeUpdateModelFromCache();
			
			if (controlConnectionFactory != null) {
				executeUpdateModelFromBackend(controlConnectionFactory);
			} else {
				sendModelPersonLogEntry(ModelLogType.ERROR, "No hay una conexión disponible con el backend en estos momentos.");
			}
		}
	}

	private void executeUpdateModelFromCache() {
		rwl.readLock().lock();
		boolean updating = updateModelThreadFromCache != null;
		rwl.readLock().unlock();
		if (updating) {
			sendModelPersonLogEntry(ModelLogType.ERROR, "Se ha intentado lanzar la carga del modelo cuando este preceso ya esta en ejecutandose.");
		} else {
			startModelUpdateFromCache();
		}
	}

	private void startModelUpdateFromCache() {
		try {
			rwl.writeLock().lock();
			// Se lanza el thread ..
			updateModelThreadFromCache = new Thread(new ModelUpdateFromCacheTask());
			// .. y se ejecuta.
			updateModelThreadFromCache.start();
			// se notifica el inicio de la actualizacion
			checkModelUpdatingStatus();
			sendModelPersonLogEntry(ModelLogType.INFO, "Se ha iniciado la carga del modelo desde la cache.");
		} finally {
			rwl.writeLock().unlock();
		}
	}

	private class ModelUpdateFromCacheTask implements Runnable {

		public ModelUpdateFromCacheTask() {
		}

		@Override
		public void run() {
			try {
				// Se anota el inicio de la carga
				Instant inicio = Instant.now();

				// Se ejecuta la carga
				ModelSIPComponent.this.modelWrapper = EMFModelWrapper.newFileBuilder(ModelSIPComponent.this::sendLogEntry).build();

				// La carga ha finalizado correctamente, se notifica
				Duration duration = Duration.between(inicio, Instant.now());
				long secs = duration.getSeconds();
				sendModelPersonLogEntry(ModelLogType.INFO, String.format("Carga finalizada correctamente desde la cache (en %d secs)", secs));
				sendUpdateModelState(new ModelStatus(getModelDate(), getModelPersons()));
			} catch (EMFModelWrapperException e) {
				sendModelPersonLogEntry(ModelLogType.ERROR, String.format("Error duranle la carga (%s).", e.getMessage()));
			} catch (Throwable t) {
				sendModelPersonLogEntry(ModelLogType.ERROR, String.format("Error desconocido durante la carga (%s).", t.getMessage()));
			} finally {
				try {
					rwl.writeLock().lock();
					updateModelThreadFromCache = null;
				} finally {
					checkModelUpdatingStatus();
					rwl.writeLock().unlock();
				}
			}
		}

	}

	private void executeUpdateModelFromBackend(IControlConnectionFactory controlConnectionFactory) {
		rwl.readLock().lock();
		boolean updating = updateModelThreadFromBackend != null;
		rwl.readLock().unlock();
		if (updating) {
			sendModelPersonLogEntry(ModelLogType.ERROR, "Se ha intentado lanzar la carga del modelo cuando este preceso ya esta en ejecutandose.");
		} else {
			startModelUpdateFromBackend(controlConnectionFactory);
		}
	}

	private void startModelUpdateFromBackend(IControlConnectionFactory controlConnectionFactory) {
		try {
			rwl.writeLock().lock();
			// Se lanza el thread ..
			updateModelThreadFromBackend = new Thread(new ModelUpdateFromBackendTask(controlConnectionFactory));
			// .. y se ejecuta.
			updateModelThreadFromBackend.start();
			// se notifica el inicio de la actualizacion
			checkModelUpdatingStatus();
			sendModelPersonLogEntry(ModelLogType.INFO, "Se ha iniciado la carga del modelo.");
		} finally {
			rwl.writeLock().unlock();
		}
	}

	private class ModelUpdateFromBackendTask implements Runnable {

		private IControlConnectionFactory connectionFactory;

		public ModelUpdateFromBackendTask(IControlConnectionFactory connectionFactory) {
			this.connectionFactory = connectionFactory;
		}

		@Override
		public void run() {
			try {
				// Se anota el inicio de la carga
				Instant inicio = Instant.now();

				// Se ejecuta la carga
				ModelSIPComponent.this.modelWrapper = EMFModelWrapper.newConnectionFactoryBuilder(connectionFactory, ModelSIPComponent.this::sendLogEntry).build();

				// La carga ha finalizado correctamente, se notifica
				Duration duration = Duration.between(inicio, Instant.now());
				long secs = duration.getSeconds();
				sendModelPersonLogEntry(ModelLogType.INFO, String.format("Carga finalizada correctamente (en %d secs)", secs));
				sendUpdateModelState(new ModelStatus(getModelDate(), getModelPersons()));
			} catch (EMFModelWrapperException e) {
				sendModelPersonLogEntry(ModelLogType.ERROR, String.format("Error duranle la carga (%s).", e.getMessage()));
			} catch (IOException io) {
				sendModelPersonLogEntry(ModelLogType.ERROR, String.format("Error de IO (%s).", io.getMessage()));
			} catch (Throwable t) {
				sendModelPersonLogEntry(ModelLogType.ERROR, String.format("Error desconocido durante la carga (%s).", t.getMessage()));
			} finally {
				try {
					rwl.writeLock().lock();
					updateModelThreadFromBackend = null;
				} finally {
					checkModelUpdatingStatus();
					rwl.writeLock().unlock();
				}
			}
		}

	}
	
	/////////////////////////////////////////////////////////////
	// Control de la cache de fotografias
	/////////////////////////////////////////////////////////////

	@Override
	public void updatePhotosFromBackend() {
		synchronized (this) {
			if (diskCache != null && controlConnectionFactory != null) {
				executeUpdatePhotos(controlConnectionFactory, diskCache);
			} else {
				sendModelPhotoLogEntry(ModelLogType.ERROR, "No hay una conexión disponible con el backend en estos momentos.");
			}
		}
	}
	
	private void executeUpdatePhotos(IControlConnectionFactory connectionFactory, IDiskCache diskCache) {
		rwlC.readLock().lock();
		boolean updating = updatePhotosThread != null;
		rwlC.readLock().unlock();
		if (updating) {
			sendModelPhotoLogEntry(ModelLogType.ERROR, "Se ha intentado lanzar la carga del modelo cuando este preceso ya esta en ejecutandose.");
		} else {
			startPhotosUpdateFromBackend(connectionFactory, diskCache);
		}		
	}

	private void sendPhotosUpdatingStatus(boolean updating) {
		Consumer<Boolean> localPhotosUpdating = photosUpdating;
		if (localPhotosUpdating != null) {
			localPhotosUpdating.accept(updating);
		}
	}
	
	private void checkPhotosUpdatingStatus() {
		if (updatePhotosThread == null && controlConnectionFactory != null) {
			sendPhotosUpdatingStatus(false);
		} else {
			sendPhotosUpdatingStatus(true);
		}
	}
	
	@Override
	public void setUpdatePhotosUpdatingTracker(Consumer<Boolean> photosUpdating) {
		this.photosUpdating = photosUpdating;
		try {
			rwlC.writeLock().lock();
			checkPhotosUpdatingStatus();
		} finally {
			rwlC.writeLock().unlock();
		}
	}

	private void startPhotosUpdateFromBackend(IControlConnectionFactory connectionFactory, IDiskCache diskCache) {
		try {
			rwlC.writeLock().lock();
			// Se lanza el thread ..
			updatePhotosThread = new Thread(new PhotoUpdateFromBackendTask(connectionFactory, diskCache));
			// .. y se ejecuta.
			updatePhotosThread.start();
			// se notifica el inicio de la actualizacion
			checkPhotosUpdatingStatus();
			sendModelPhotoLogEntry(ModelLogType.INFO, "Se ha iniciado la carga de las fotos.");
		} finally {
			rwlC.writeLock().unlock();
		}
	}

	private class PhotoUpdateFromBackendTask implements Runnable {

		private IControlConnectionFactory connectionFactory;
		private IDiskCache diskCache;

		public PhotoUpdateFromBackendTask(IControlConnectionFactory connectionFactory, IDiskCache diskCache) {
			this.connectionFactory = connectionFactory;
			this.diskCache = diskCache;
		}

		@Override
		public void run() {
			try {
				// Se anota el inicio de la carga
				Instant inicio = Instant.now();

				// Se ejecuta la carga
				ModelSIPComponent.this.cacheModelPhotos = CacheModelPhotos.newCacheConnectionFactoryBuilder(connectionFactory, diskCache, ModelSIPComponent.this::sendLogEntry).build();
				
				// La carga ha finalizado correctamente, se notifica
				Duration duration = Duration.between(inicio, Instant.now());
				long secs = duration.getSeconds();
				sendModelPhotoLogEntry(ModelLogType.INFO, String.format("Carga finalizada correctamente (en %d secs)", secs));
			} catch (CacheModelPhotosException e) {
				sendModelPhotoLogEntry(ModelLogType.ERROR, String.format("Error durante la carga: %s.", e.getMessage()));
			} catch (Throwable t) {
				sendModelPhotoLogEntry(ModelLogType.ERROR, String.format("Error desconocido durante la carga (%s).", t.getMessage()));
			} finally {
				try {
					rwlC.writeLock().lock();
					updatePhotosThread = null;
				} finally {
					checkPhotosUpdatingStatus();
					rwlC.writeLock().unlock();
				}
			}
		}

	}

	/////////////////////////////////////////////////////////////
	// Estado del modelo
	/////////////////////////////////////////////////////////////

	@Override
	public LocalDateTime getModelDate() {
		synchronized (this) {
			return modelWrapper == null ? null : modelWrapper.getModelDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		}
	}
	
	@Override
	public int getModelPersons() {
		synchronized (this) {
			return modelWrapper == null ? null : modelWrapper.getModelPersons();
		}
	}

	@Override
	public void setUpdateModelStateTracker(Consumer<ModelStatus> state) {
		this.state = state;
	}

	private void sendUpdateModelState(ModelStatus modelStatus) {
		Consumer<ModelStatus> localConsumer = this.state;
		if (localConsumer != null) {
			localConsumer.accept(modelStatus);
		}
	}

	/////////////////////////////////////////////////////////////
	// Acceso al modelo
	/////////////////////////////////////////////////////////////

	@Override
	public IPerson getPersonByAccreditation(IAccreditation accreditation) throws ModelException {
		synchronized (this) {
			if (modelWrapper == null) {
				throw new ModelException("No hay ningun modelo subyacente con informacion.");
			} else {
				try {
					return modelWrapper.getPersonByAccreditation(accreditation);
				} catch (EMFModelWrapperException e) {
					throw new ModelException("Error al intentar obtener la persona desde una acreditacion.", e);
				}
			}
		}
	}

	@Override
	public List<IPerson> searchPerson(Predicate<IPerson> predicate) throws ModelException {
		synchronized (this) {
			if (modelWrapper == null) {
				throw new ModelException("No hay ningun modelo subyacente con informacion.");
			} else {
				try {
					return modelWrapper.getPersonBySearch(predicate);
				} catch (EMFModelWrapperException e) {
					throw new ModelException("Error al intentar obtener la persona desde una condición de busqueda.", e);
				}
			}
		}
	}

	@Override
	public IPhoto getPhotoById(IPersonIdentifier personIdentifier) throws ModelException {
		synchronized (this) {
			if (cacheModelPhotos == null) {
				try {
					cacheModelPhotos = CacheModelPhotos.newCacheFactoryBuilder(diskCache, this::sendLogEntry).build();
					return cacheModelPhotos.getPhotoById(personIdentifier);
				} catch (CacheModelPhotosException e) {
					throw new ModelException(e.getMessage());
				}
			} else {
				try {
					return cacheModelPhotos.getPhotoById(personIdentifier);
				} catch (CacheModelPhotosException e) {
					throw new ModelException(e.getMessage());
				}
			}
		}
	}

}
