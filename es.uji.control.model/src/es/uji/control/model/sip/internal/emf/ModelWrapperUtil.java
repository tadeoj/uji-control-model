package es.uji.control.model.sip.internal.emf;

import es.uji.control.domain.people.AccreditationType;
import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.ILinkage;
import es.uji.control.domain.people.IPerson;
import es.uji.control.domain.people.PersonIdentifierType;
import es.uji.control.sip.model.emf.sip.Accreditation;
import es.uji.control.sip.model.emf.sip.Linkage;
import es.uji.control.sip.model.emf.sip.Person;
import es.uji.control.sip.model.emf.sip.SipFactory;

public class ModelWrapperUtil {

	static public Person domainToEMF(IPerson domainPerson) {
		Person personEMF = SipFactory.eINSTANCE.createPerson();
		personEMF.setId(PersonIdentifierType.bytesToGeneralLongId(domainPerson.getId().getRaw()));
		personEMF.setIdentification(domainPerson.getIdentification());
		personEMF.setName(domainPerson.getName());
		personEMF.setFirstLastName(domainPerson.getFirstLastName());
		personEMF.setSecondLastName(domainPerson.getSecondLastName());
		return personEMF;
	}
	
	static public Accreditation domainToEMF(IAccreditation domainAccreditation) {
		Accreditation accreditationEMF = SipFactory.eINSTANCE.createAccreditation();
		accreditationEMF.setType(domainAccreditation.getType().toString());
		accreditationEMF.setRaw(AccreditationType.bytesToGeneralLongId(domainAccreditation.getRaw()));
		return accreditationEMF;
	}

	static public Linkage domainToEMF(ILinkage domainLinkage) {
		Linkage linkageEMF = SipFactory.eINSTANCE.createLinkage();
		linkageEMF.setName(domainLinkage.getName());
		return linkageEMF;
	}
	
}
