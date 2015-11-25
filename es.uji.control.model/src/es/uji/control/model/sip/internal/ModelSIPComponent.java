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
import es.uji.control.model.sip.AsyncModelSIPEvent;
import es.uji.control.model.sip.AsyncModelSIPEventType;
import es.uji.control.model.sip.IModelSIP;
import es.uji.control.model.sip.ModelSIPException;
import es.uji.control.model.sip.internal.emf.EMFModelWrapper;
import es.uji.control.model.sip.internal.emf.EMFModelWrapperException;

@Component(name = "model.sip.component", immediate = true)
public class ModelSIPComponent implements IModelSIP {

	private IControlConnectionFactory controlConnectionFactory;

	private EMFModelWrapper modelWrapper;
	
	volatile private Thread updateModelThread;
	
	final static public String PERSON_SOURCE = "model.persons";

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
	// Metodos que controlan el modelo
	/////////////////////////////////////////////////////////////
	
	@Override
	public void updateModelFromBackend(Consumer<AsyncModelSIPEvent> consumer) {
		synchronized (this) {
			if (controlConnectionFactory != null) {
				executeUpdateModelFromBackend(consumer);
			} else {
				consumer.accept(new AsyncModelSIPEvent(Instant.now(), PERSON_SOURCE, AsyncModelSIPEventType.ERROR, "No hay conexion con el backend en estos momentos."));
			}
		}
	}
	
	private void executeUpdateModelFromBackend(final Consumer<AsyncModelSIPEvent> consumer) {
		if (updateModelThread != null) {
			consumer.accept(new AsyncModelSIPEvent(Instant.now(), PERSON_SOURCE, AsyncModelSIPEventType.ERROR, "Ya hay un proceso de carga del modelo en curso."));
		} else {
			// Se crea el thread
			updateModelThread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Instant inicio = Instant.now();
						// Se ejecuta la carga
						EMFModelWrapper tmpModelWrapper = EMFModelWrapper.newConnectionFactoryBuilder(controlConnectionFactory, consumer).build();
						// Se actualiza el modelo y se informa
						ModelSIPComponent.this.modelWrapper = tmpModelWrapper;
						Duration duration = Duration.between(inicio, Instant.now());
						long secs = duration.getSeconds();
						consumer.accept(new AsyncModelSIPEvent(Instant.now(), PERSON_SOURCE, AsyncModelSIPEventType.INFO, String.format("Caraga finalizada correctamente (en %d secs)", secs)));
					} catch (EMFModelWrapperException e) {
						consumer.accept(new AsyncModelSIPEvent(Instant.now(), PERSON_SOURCE, AsyncModelSIPEventType.ERROR, String.format("Error duranle la carga (%s).", e.getMessage())));
					} catch (Throwable t) {
						consumer.accept(new AsyncModelSIPEvent(Instant.now(), PERSON_SOURCE, AsyncModelSIPEventType.ERROR, String.format("Error desconocido (%s).", t.getMessage())));
					} finally {
						updateModelThread = null;
					}
				}
			});
			// Se ejecuta
			updateModelThread.start();
		}
	}
	
	@Override
	public void updatePhotosFromBackend(Consumer<AsyncModelSIPEvent> consumer) {
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
	public IPerson getPersonByAccreditation(IAccreditation accreditation) throws ModelSIPException {
		synchronized (this) {
			if (modelWrapper == null) {
				throw new ModelSIPException("No hay ningun modelo subyacente con informacion.");
			} else {
				try {
					return modelWrapper.getPersonByAccreditation(accreditation);
				} catch (EMFModelWrapperException e) {
					throw new ModelSIPException("Error al intentar obtener la persona desde una acreditacion.", e);
				}
			}
		}
	}
	
}
