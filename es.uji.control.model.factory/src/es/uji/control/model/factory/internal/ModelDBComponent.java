/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.factory.internal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.uji.control.commons.diskcache.DiskCacheException;
import es.uji.control.commons.diskcache.ICacheEntry;
import es.uji.control.commons.diskcache.IDiskCache;
import es.uji.control.model.emf.sip.Cards;
import es.uji.control.model.emf.sip.Model;
import es.uji.control.model.emf.sip.Persons;
import es.uji.control.model.emf.sip.SipFactory;
import es.uji.control.model.emf.sip.impl.SipPackageImpl;
import es.uji.control.model.factory.IModelFactory;
import es.uji.control.model.factory.QueryModelException;
import es.uji.control.sip.db.PerFoto;
import es.uji.control.sip.db.PerVwPersonasSubvinculo;
import es.uji.control.sip.db.ScuVPersona;
import es.uji.control.sip.db.ScuVTarjeta;

@Component(name = "model.db", immediate = true)
public class ModelDBComponent implements IModelFactory {
	
	// Entities
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManagerQuery;
	private EntityManager entityManagerSyncronize;

	private List<ScuVTarjeta> listScuVTarjeta = new ArrayList<ScuVTarjeta>();
	private List<PerVwPersonasSubvinculo> listPersonasSubvinculos = new ArrayList<PerVwPersonasSubvinculo>();
	private List<ScuVPersona> listScuVPersona = new ArrayList<ScuVPersona>();
	private IDiskCache diskCache;
	static final Logger logger = LoggerFactory.getLogger(ModelDBComponent.class);
	
	public void activate() throws QueryModelException {
		// Se obtiene un EntityManagerFactory al iniciar el componente
		try {
			this.entityManagerFactory = getEntityManagerFactory();
		} catch (Exception ex) {
			throw new QueryModelException(ex);
		}
	}
	
	public void shutdown() {
		entityManagerFactory.close();
	}

	public void setDiskCache(IDiskCache diskCache) {
		this.diskCache = diskCache;
	}
	
	@Override
	public void createEntitiesManager() throws QueryModelException {
		try {
			entityManagerQuery = entityManagerFactory.createEntityManager();
			entityManagerSyncronize = entityManagerFactory.createEntityManager();
		} catch (Exception ex) {
			throw new QueryModelException(ex);
		}
	}
	
	///////////////////////////////////////////////////////////
	// Consulta del modelo en la Base de Datos.
	///////////////////////////////////////////////////////////

	@Override
	public Model queryModel() throws QueryModelException {
		SipPackageImpl.init();
		SipFactory factory = SipFactory.eINSTANCE;
		Model model = factory.createModel();
		Date date = new Date();
		
		listScuVTarjeta = null;
		listPersonasSubvinculos = null;
		listScuVPersona = null;
		
		try {
			entityManagerQuery.getTransaction().begin();
			TypedQuery<ScuVTarjeta> cardsQuery = entityManagerQuery.createQuery("select x from ScuVTarjeta x", ScuVTarjeta.class);
			listScuVTarjeta = cardsQuery.getResultList();
	
			TypedQuery<PerVwPersonasSubvinculo> personasSubvinculosQuery = entityManagerQuery.createQuery("select x from PerVwPersonasSubvinculo x", PerVwPersonasSubvinculo.class);
			listPersonasSubvinculos = personasSubvinculosQuery.getResultList();

			TypedQuery<ScuVPersona> personsQuery = entityManagerQuery.createQuery("select x from ScuVPersona x order by x.perId", ScuVPersona.class);
			listScuVPersona = personsQuery.getResultList();
			entityManagerQuery.getTransaction().commit();

		} catch (Exception ex) {
			logger.error("No se ha podido consultar la base de datos.", ex);
			entityManagerQuery.getTransaction().rollback();
			entityManagerQuery.clear();
			throw new QueryModelException(ex);
		}

		model.setDate(date);
		
		// Se recorren las tarjetas y se almacenan en la relación con el modelo			
		for (ScuVTarjeta perTarjeta : listScuVTarjeta) {
			
			// Se genera una instancia del objeto tarjeta del modelo.
			Cards card = factory.createCards();
			card.setId(perTarjeta.getTarjetaId());
			card.setDescription(perTarjeta.getDescripcion());
			card.setPerId(perTarjeta.getPerId());
			card.setSerialNumber(perTarjeta.getSerialNumber());
			card.setCancelationDate(perTarjeta.getFCancelacion());
			card.setCreationDate(perTarjeta.getFCreacion());
			card.setIssueDate(perTarjeta.getFEmision());
		
			model.getModelCardsList().add(card);
		}
		
		Persons person = null;
		
		// Se recorren las personas y se almacenan todas las relaciones con el modelo, con las tarjetas, y con las autorizaciones
		for (ScuVPersona scuVPersona : listScuVPersona) {
			
			// Se crea una instancia del objeto Persons del modelo EMF
			person = factory.createPersons();
			
			// Se completan los campos del objeto Persons del modelo EMF
			person.setId(scuVPersona.getPerId());
			person.setIdentification(scuVPersona.getIdentificacion());
			person.setName(scuVPersona.getNombre());
			person.setFirstName1(scuVPersona.getApellido1());
			person.setFirstName2(scuVPersona.getApellido2());
			
			// TODO: Falata reimplementar el modelo
			//person.setLink(scuVPersona.getVinculo());
			
			// Se recorre la lista de tarjetas
			for (ScuVTarjeta scuVTarjeta : listScuVTarjeta) {
				
				if (person.getId() == scuVTarjeta.getPerId()) {
					// Se crea una instancia del objeto Cards del modelo EMF
					Cards card = factory.createCards();
					
					// Se completan los campos del objeto Cards del modelo EMF
					card.setId(scuVTarjeta.getTarjetaId());
					card.setPerId(scuVTarjeta.getPerId());
					card.setCreationDate(scuVTarjeta.getFCreacion());
					card.setIssueDate(scuVTarjeta.getFEmision());
					card.setCancelationDate(scuVTarjeta.getFCancelacion());
					card.setDescription(scuVTarjeta.getDescripcion());
					card.setSerialNumber(scuVTarjeta.getSerialNumber());
					
					// Se incluye la lista de tarjetas relacionadas con la persona
					person.getCardsList().add(card);
				}
			}
							
			// Se incluye la persona en el modelo.
			model.getModelPersonsList().add(person);
		}
		entityManagerQuery.clear();
		logger.info("Se ha cargado en memoria el modelo de datos de la base de datos correctamente.");
		return model;
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	// Sincroniza las fotos de la Base de datos con la copia persistente en disco 
	//////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void syncronizePhotos() throws QueryModelException {
		List<Long> listPerTarjetas = new ArrayList<Long>();
		// Se obtienen las fotos de los usuarios que tienen tarjetas desde la base de datos		
		try {
			TypedQuery<Long> cardsQuery = entityManagerSyncronize.createQuery("select distinct x.perId from ScuVTarjeta x", Long.class);
			listPerTarjetas = cardsQuery.getResultList();
		} catch (Exception ex) {
			logger.error("No se ha podido consultar la base de datos.", ex);
			entityManagerSyncronize.clear();
			throw new QueryModelException(ex);
		}
		
		for (Long id : listPerTarjetas) {
			
			try {
	
				if (id == 164200) {
					selectPerson(id);
				} else {
					selectPerson(id);
				}
			} catch (QueryModelException qmEx) {
				logger.info("No se ha podido obtener la Foto del usuario de la base de datos.");
			}
		}
		entityManagerSyncronize.clear();
	}
	
	private void selectPerson(long id) throws QueryModelException {
		ICacheEntry cacheEntry = null;
		PerFoto perFotos = null;
		
		try {
			TypedQuery<PerFoto> photosQuery = entityManagerSyncronize.createQuery("select x from PerFotos x where x.perId = '" + id + "'", PerFoto.class);
			perFotos = photosQuery.getSingleResult();
		} catch (Exception ex) {
			entityManagerSyncronize.clear();
			throw new QueryModelException(ex);
		}
		
		byte[] cacheEntryBytes = null;
		Date cacheEntryTimestamp = null;
		
		try {
			cacheEntry = this.diskCache.getEntry(perFotos.getPerId());
		} catch (DiskCacheException dcEx) {
			logger.error("No se ha podido obtener la entrada para el perId indicado", dcEx);
		}
		
		if (cacheEntry != null) {
			try {
				cacheEntryBytes = cacheEntry.getBytes();
				cacheEntryTimestamp = cacheEntry.getTimestamp();
				if (cacheEntryBytes == null || cacheEntryTimestamp == null || cacheEntryTimestamp.compareTo(perFotos.getFecha()) < 0) {
					try {
						diskCache.addEntry(perFotos.getPerId(), perFotos.getFecha(), perFotos.getBinario());
					} catch (DiskCacheException dcEx) {
						logger.error("No se ha podido persistir la entrada en disco", dcEx);
					}
				}
			} catch (DiskCacheException dcEx) {
				logger.error("No se han podido obtener los parametros de la entrada", dcEx);
			}	
		} else {
			try {
				diskCache.addEntry(perFotos.getPerId(), perFotos.getFecha(), perFotos.getBinario());
			} catch (DiskCacheException dcEx) {
				logger.error("No se ha podido persistir la entrada en disco", dcEx);
			}
		}
		entityManagerSyncronize.clear();
	}
	
	// Este metodo se instancia una sola vez para obtener un EntityManager
	private EntityManagerFactory getEntityManagerFactory() throws Exception {
		try {
			HashMap<String, Object> properties = new HashMap<String, Object>();
			properties.put(PersistenceUnitProperties.CLASSLOADER, ScuVTarjeta.class.getClassLoader());
			properties.put("eclipselink.logging.level", "FINE");
			properties.put("eclipselink.logging.timestamp", "false");
			properties.put("eclipselink.logging.session", "false");
			properties.put("eclipselink.logging.thread", "false");
			properties.put("javax.persistence.jdbc.url", "jdbc:oracle:thin:@jaumei05-cs.uji.es:1521:alma1");
			properties.put("javax.persistence.jdbc.user", "*******");
			properties.put("javax.persistence.jdbc.password", "********");
			properties.put("eclipselink.jdbc.read-connections.min", "3");
			properties.put("eclipselink.jdbc.write-connections.min", "3");
			properties.put("javax.persistence.jdbc.driver", "oracle.jdbc.driver.OracleDriver");
			EntityManagerFactory entityManagerFactory = new PersistenceProvider().createEntityManagerFactory("sip", properties);
			return entityManagerFactory;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	static public Logger getLogger() {
		return logger;
	}

}
