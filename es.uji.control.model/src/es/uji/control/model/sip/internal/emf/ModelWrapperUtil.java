package es.uji.control.model.sip.internal.emf;

import es.uji.control.domain.people.IPerson;
import es.uji.control.sip.model.emf.sip.Person;
import es.uji.control.sip.model.emf.sip.SipFactory;

public class ModelWrapperUtil {
	
	 static public Person domainToEMF(IPerson domainPerson) {
		Person personEMF = SipFactory.eINSTANCE.createPerson();
		personEMF.setId(Long.valueOf(domainPerson.getId().getRaw()));
		personEMF.setIdentification(domainPerson.getIdentification());
		personEMF.setName(domainPerson.getName());
		personEMF.setFirstLastName(domainPerson.getFirstLastName());
		personEMF.setSecondLastName(domainPerson.getSecondLastName());
		return personEMF;
	}

}
