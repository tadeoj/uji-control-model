/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.cache.internal;

import java.io.IOException;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.uji.control.model.cache.IModelCache;
import es.uji.control.sip.model.emf.sip.Cards;
import es.uji.control.sip.model.emf.sip.Model;
import es.uji.control.sip.model.emf.sip.Persons;
import es.uji.control.sip.model.emf.sip.SipFactory;
import es.uji.control.sip.model.emf.sip.impl.SipPackageImpl;

public class Component implements IModelCache {

	static final Logger logger = LoggerFactory.getLogger(Component.class);

	private SipFactory factory;
	private URI fileURI;

	public void startup(BundleContext context) {
		SipPackageImpl.init();
		factory = SipFactory.eINSTANCE;
		String uri = System.getProperty("user.home") + "\\Universitat Jaume I\\SIP\\cache\\cache.ecore";
		//String uri = "C:\\bin\\Universitat Jaume I\\SCAID DATA\\cache\\cache.ecore";
		/*File file = context.getDataFile("cache.ecore");
		String uri = file.getAbsolutePath();*/
		fileURI = URI.createFileURI(uri);
	}
	
	public void shutdown() {
	}
	
	////////////////////////////////////////////////////////////////////
	// Gestión de la cache del modelo
	////////////////////////////////////////////////////////////////////
	@Override
	public Model readModelFromCache() {
		
		// Se crea el recurso del cual se va a obtener el modelo.
		Resource resource = new XMIResourceFactoryImpl().createResource(fileURI);
		Model model = factory.createModel();
		
		try {
			resource.load(null);
			logger.info("El modelo de datos se ha cargado en memoria correctamente.");
		} catch (Exception ioEx) {
			logger.info("No se ha podido cargar en memoria el modelo de datos.");	
			return null;
		}
		
		// Se comprueba que el recurso no esta vacio.
		if (resource.getContents().size() == 0) {
			return null;
		}
		
		// Se obtiene un XmiResource
		XMIResource xmiResource = (XMIResource) resource;			
		
		// Se obtiene el iterador para obtener los contenidos
		TreeIterator<EObject> contents = xmiResource.getAllContents();
		
		// Se empieza a construir el modelo respecto el recurso
		while (contents.hasNext()) {
			EObject object = contents.next();
			
			if (object instanceof Model) {
				
				// Se recupera la fecha del modelo
				model.setDate(((Model) object).getDate());
			} else {
				if (object instanceof Persons) {
					TreeIterator<EObject> personsContents = object.eAllContents();
					
					// Se crea una instancia del objeto Persons del modelo EMF
					Persons persons = factory.createPersons();

					// Se completan los campos del objeto Persons del modelo EMF
					persons.setId(((Persons) object).getId());
					persons.setIdentification(((Persons) object).getIdentification());
					persons.setName(((Persons) object).getName());
					persons.setFirstName1(((Persons) object).getFirstName1());
					persons.setFirstName2(((Persons) object).getFirstName2());
					persons.setLink(((Persons) object).getLink());

					while (personsContents.hasNext()) {
						EObject personContent = personsContents.next();
						if (personContent instanceof Cards) {
							
							// Se crea una instancia del objeto Cards del modelo EMF
							Cards cards = factory.createCards();
							
							// Se completan los campos del objeto Cards del modelo EMF
							cards.setId(((Cards) personContent).getId());
							cards.setPerId(((Cards) personContent).getPerId());
							cards.setCreationDate(((Cards) personContent).getCreationDate());
							cards.setIssueDate(((Cards) personContent).getIssueDate());
							cards.setCancelationDate(((Cards) personContent).getCancelationDate());
							cards.setDescription(((Cards) personContent).getDescription());
							cards.setSerialNumber(((Cards) personContent).getSerialNumber());
						
							// Se incluye la lista de tarjetas relacionadas con la persona
							persons.getCardsList().add(cards);
						}
					}
					// Se incluye la persona en el modelo.
					model.getModelPersonsList().add(persons);
				}
				if (object instanceof Cards) {
					
					// Se crea una instancia del objeto Cards del modelo EMF
					Cards cards = factory.createCards();
					
					// Se completan los campos del objeto Cards del modelo EMF
					cards.setId(((Cards) object).getId());
					cards.setPerId(((Cards) object).getPerId());
					cards.setCreationDate(((Cards) object).getCreationDate());
					cards.setIssueDate(((Cards) object).getIssueDate());
					cards.setCancelationDate(((Cards) object).getCancelationDate());
					cards.setDescription(((Cards) object).getDescription());
					cards.setSerialNumber(((Cards) object).getSerialNumber());
					
					// Se incluye la tarjeta en el modelo.
					model.getModelCardsList().add(cards);
				}
			}
		}
		return model;
	}

	@Override
	public void writeModelToCache(Model model) {
		
		// Se crea el recurso en el cual se va a persistir el modelo.
		Resource resource = new XMIResourceFactoryImpl().createResource(fileURI);
		resource.getContents().add(model);
		try {
			resource.save(null);
			logger.info("Se ha persistido en disco el modelo de datos actual.");
		} catch (IOException ioEx) {
			logger.error("No se ha podido persistir el modelo de datos en disco.", ioEx);
		}
	}

	static public Logger getLogger() {
		return logger;
	}

}
