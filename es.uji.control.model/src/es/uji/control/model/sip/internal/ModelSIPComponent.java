/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.sip.internal;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.IPerson;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnectionFactory;
import es.uji.control.model.sip.ModelLogEntry;
import es.uji.control.model.sip.ModelLogSource;
import es.uji.control.model.sip.ModelLogType;
import es.uji.control.model.sip.IModel;
import es.uji.control.model.sip.ModelException;
import es.uji.control.model.sip.internal.emf.EMFModelWrapper;
import es.uji.control.model.sip.internal.emf.EMFModelWrapperException;

@Component(name = "model.sip.component", immediate = true)
public class ModelSIPComponent implements IModel {

	private IControlConnectionFactory controlConnectionFactory;

	private EMFModelWrapper modelWrapper;
	
	volatile private Consumer<ModelLogEntry> logger;
	
	volatile private Consumer<Boolean> modelUpdating;
	
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	private Thread updateModelThread;
	
	@Activate
	public void activate() {
	}
	
	@Deactivate
	public void deactivate() {
	}
	
	@Reference(policy=ReferencePolicy.DYNAMIC, cardinality=ReferenceCardinality.OPTIONAL, name="controlConnectionFactory")
	public void bindConnectionFactorySPI(IControlConnectionFactory controlConnectionFactory, Map<String,?> properties) {
		synchronized (this) {
			this.controlConnectionFactory = controlConnectionFactory;
		}
	}
	
	public void unbindConnectionFactorySPI(IControlConnectionFactory controlConnectionFactory, Map<String,?> properties) {
		synchronized (this) {
			this.controlConnectionFactory = null;
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
			ModelLogEntry entry = new ModelLogEntry(
					Instant.now(), 
					ModelLogSource.PERSONS, 
					type, 
					msg
				);
			localConsumer.accept(entry);
		}
	}
	
	/////////////////////////////////////////////////////////////
	// Metodos que controlan el modelo
	/////////////////////////////////////////////////////////////
	
	@Override
	public void setUpdateModelUpdatingListener(Consumer<Boolean> modelUpdating) {
		this.modelUpdating = modelUpdating;
		try {
			rwl.writeLock().lock();
			sendModelUpdatingStatus(updateModelThread != null);
		} finally {
			rwl.writeLock().unlock();
		}
	}
	
	private void sendModelUpdatingStatus(boolean updating) {
		Consumer<Boolean> localModelUpdating = modelUpdating;
		if (localModelUpdating != null) {
			localModelUpdating.accept(updating);
		}
	}

	@Override
	public void updateModelFromBackend() {
		synchronized (this) {
			if (controlConnectionFactory != null) {
				executeUpdateModelFromBackend(controlConnectionFactory);
			} else {
				sendModelPersonLogEntry(ModelLogType.ERROR, "No hay conexion con el backend en estos momentos.");
			}
		}
	}
	
	private void executeUpdateModelFromBackend(IControlConnectionFactory controlConnectionFactory) {
		try {
			rwl.readLock().lock();
			if (updateModelThread != null) {
				sendModelPersonLogEntry(ModelLogType.ERROR, "Se ha intentado lanzar la carga del modelo cuando este preceso ya esta en ejecutandose.");
			} else {
				startModelUpdate(controlConnectionFactory);
			}
		} finally {
			rwl.readLock().unlock();
		}
	}
	
	private void startModelUpdate(IControlConnectionFactory controlConnectionFactory) {
		try {
			rwl.writeLock().lock();
			// Se lanza el thread
			updateModelThread = new Thread(new ModelUpdateTask(controlConnectionFactory));
			// Se ejecuta
			updateModelThread.start();
			// se notifica el inicio de la actualizacion
			sendModelUpdatingStatus(true);
		} finally {
			rwl.writeLock().unlock();
		}
	}
	
	private class ModelUpdateTask implements Runnable {
		
		private IControlConnectionFactory connectionFactory;
		
		public ModelUpdateTask(IControlConnectionFactory connectionFactory) {
			this.connectionFactory = connectionFactory;
		}

		@Override
		public void run() {
			try {
				Instant inicio = Instant.now();
				// Se ejecuta la carga
				EMFModelWrapper tmpModelWrapper = EMFModelWrapper.newConnectionFactoryBuilder(connectionFactory, ModelSIPComponent.this::sendLogEntry).build();
				// Se actualiza el modelo y se informa
				ModelSIPComponent.this.modelWrapper = tmpModelWrapper;
				Duration duration = Duration.between(inicio, Instant.now());
				long secs = duration.getSeconds();
				sendModelPersonLogEntry(ModelLogType.INFO, String.format("Carga finalizada correctamente (en %d secs)", secs));
			} catch (EMFModelWrapperException e) {
				sendModelPersonLogEntry(ModelLogType.ERROR, String.format("Error duranle la carga (%s).", e.getMessage()));
			} catch (Throwable t) {
				sendModelPersonLogEntry(ModelLogType.ERROR, String.format("Error desconocido (%s).", t.getMessage()));
			} finally {
				try {
					rwl.writeLock().lock();
					updateModelThread = null;
					// Se notifica el final de la actualizacion
					sendModelUpdatingStatus(false);
				} finally {
					rwl.writeLock().unlock();
				}
			} 
		}
		
	}
	
	@Override
	public void updatePhotosFromBackend() {
	}

	
	/////////////////////////////////////////////////////////////
	// Estado del modelo
	/////////////////////////////////////////////////////////////
	
	@Override
	public Date getModelDate() {
		synchronized (this) {
			return modelWrapper == null ? null : modelWrapper.getModelDate();
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

}
