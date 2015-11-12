package es.uji.control.model.sip.util;

import org.eclipse.emf.common.util.EList;

import es.uji.control.domain.people.AccreditationBuilder;
import es.uji.control.model.factory.domain.IModel;
import es.uji.control.model.factory.domain.ModelBuilder;
import es.uji.control.sip.model.emf.sip.Accreditation;
import es.uji.control.sip.model.emf.sip.Model;
import es.uji.control.sip.model.emf.sip.Person;

public class EMF2Domain {

	static public IModel convert(Model modelEMF) throws ModelConverterException {
		
		if (modelEMF != null) {
			
			ModelBuilder modelBuilder = new ModelBuilder();
			modelBuilder.setDate(modelEMF.getDate());
			
			EList<Accreditation> modelCardsList = modelEMF.getModelCardsList();
			EList<Person> modelPersonsList = modelEMF.getModelPersonsList();
			
			AccreditationBuilder accreditationBuilder = null;
			for (Accreditation accreditation : modelCardsList) {
				
				accreditationBuilder = new AccreditationBuilder();
				
				// TODO: FAlata implementar
			}
			
			return null;

		} else {
			throw new ModelConverterException("El modelo EMF que se quiere convertir esta vacio.");
		}
		
	}
	
}
