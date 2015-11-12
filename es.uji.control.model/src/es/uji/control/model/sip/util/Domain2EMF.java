package es.uji.control.model.sip.util;

import java.util.List;

import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.ILinkage;
import es.uji.control.domain.people.IPerson;
import es.uji.control.model.factory.domain.IModel;
import es.uji.control.sip.model.emf.sip.Accreditation;
import es.uji.control.sip.model.emf.sip.Linkage;
import es.uji.control.sip.model.emf.sip.Model;
import es.uji.control.sip.model.emf.sip.Person;
import es.uji.control.sip.model.emf.sip.SipFactory;
import es.uji.control.sip.model.emf.sip.impl.SipPackageImpl;

public class Domain2EMF {

	static public Model convert(IModel domain) throws ModelConverterException {

		if (domain != null) {
			SipPackageImpl.init();
			SipFactory factory = SipFactory.eINSTANCE;
			Model model = factory.createModel();
			model.setDate(domain.getDate());
			
			List<IPerson> people = domain.getPeople();

			Person personEMF = null;

			for (IPerson person : people) {

				personEMF = factory.createPerson();
				personEMF.setId(Long.valueOf(person.getId().getRaw()));
				personEMF.setIdentification(person.getIdentification());
				personEMF.setName(person.getName());
				personEMF.setFirstLastName(person.getFirstLastName());
				personEMF.setSecondLastName(person.getSecondLastName());
				
				for (ILinkage linkage : person.getLinkages()) {
					Linkage linkageEMF = factory.createLinkage();
					linkageEMF.setName(linkage.getName());
					
					personEMF.getLinkageList().add(linkageEMF);
				}

				for (IAccreditation accreditation : person.getAccreditations()) {

					Accreditation accreditationEMF = factory.createAccreditation();
					accreditationEMF.setRaw(Long.valueOf(accreditation.getRaw()));
					accreditationEMF.setIssueDate(accreditation.getEmisionDate());
					accreditationEMF.setCancelationDate(accreditation.getCancelationDate());
					accreditationEMF.setPerson(personEMF);
					
					personEMF.getAccreditationsList().add(accreditationEMF);
					model.getModelCardsList().add(accreditationEMF);
				}

				model.getModelPersonsList().add(personEMF);
			}
			return model;
		} else {
			throw new ModelConverterException("El modelo que se quiere convertir esta vacio.");
		}
	}

}
