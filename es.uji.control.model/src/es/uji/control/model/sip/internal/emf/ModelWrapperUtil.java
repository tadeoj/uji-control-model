package es.uji.control.model.sip.internal.emf;

import java.util.ArrayList;
import java.util.List;

import es.uji.control.domain.people.AccreditationBuilder;
import es.uji.control.domain.people.AccreditationInfoBuilder;
import es.uji.control.domain.people.AccreditationType;
import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.IAccreditationInfo;
import es.uji.control.domain.people.ILinkage;
import es.uji.control.domain.people.IPerson;
import es.uji.control.domain.people.IPersonIdentifier;
import es.uji.control.domain.people.LinkageBuilder;
import es.uji.control.domain.people.PersonBuilder;
import es.uji.control.domain.people.PersonIdentifierBuilder;
import es.uji.control.domain.people.PersonIdentifierType;
import es.uji.control.sip.model.emf.sip.Accreditation;
import es.uji.control.sip.model.emf.sip.Linkage;
import es.uji.control.sip.model.emf.sip.Person;
import es.uji.control.sip.model.emf.sip.SipFactory;

public class ModelWrapperUtil {

	static public Person domainToEMF(IPerson domainPerson) {
		Person personEMF = SipFactory.eINSTANCE.createPerson();
		personEMF.setRaw(PersonIdentifierType.bytesToGeneralLongId(domainPerson.getId().getRaw()));
		personEMF.setIdentification(domainPerson.getIdentification());
		personEMF.setName(domainPerson.getName());
		personEMF.setFirstLastName(domainPerson.getFirstLastName());
		personEMF.setSecondLastName(domainPerson.getSecondLastName());
		return personEMF;
	}
	
	static public Accreditation domainToEMF(IAccreditation domainAccreditation) {
		Accreditation accreditationEMF = SipFactory.eINSTANCE.createAccreditation();
		accreditationEMF.setId(domainAccreditation.getId());
		accreditationEMF.setType(domainAccreditation.getType().toString());
		accreditationEMF.setRaw(AccreditationType.bytesToGeneralLongId(domainAccreditation.getRaw()));
		return accreditationEMF;
	}

	static public Linkage domainToEMF(ILinkage domainLinkage) {
		Linkage linkageEMF = SipFactory.eINSTANCE.createLinkage();
		linkageEMF.setName(domainLinkage.getName());
		return linkageEMF;
	}
	
	static public IPerson EMFToDomain(Person personEMF) {
		IPersonIdentifier personIdentifier = new PersonIdentifierBuilder()
				.setid(personEMF.getId())
				.setRaw(PersonIdentifierType.generalLongIdToBytes(personEMF.getRaw()))
				.setType(PersonIdentifierType.GENERAL_LONG_ID)
				.build();
		
		List<IAccreditationInfo> accreditationsInfo = new ArrayList<>(1);
		for (Accreditation accreditation : personEMF.getAccreditationsList()) {
			accreditationsInfo.add(EMFToDomain(accreditation));
		}

		List<ILinkage> linkages = new ArrayList<>(1);
		for (Linkage linkage : personEMF.getLinkageList()) {
			linkages.add(EMFToDomain(linkage));
		}
		
		IPerson person = new PersonBuilder()
				.setId(personIdentifier)
				.setName(personEMF.getName())
				.setFirstLastName(personEMF.getFirstLastName())
				.setSecondLastName(personEMF.getSecondLastName())
				.setIdentification(personEMF.getIdentification())
				.setAccreditationsInfo(accreditationsInfo)
				.setLinkages(linkages)
				.build();
		
		return person;
	}

	static public IAccreditationInfo EMFToDomain(Accreditation accreditatonEMF) {
		IAccreditation accreditation = new AccreditationBuilder()
				.setId(accreditatonEMF.getId())
				.setType(AccreditationType.MIFARE_SERIAL_NUMBER)
				.setRaw(AccreditationType.generalLongIdToBytes(accreditatonEMF.getRaw()))
				.build();
		
		IAccreditationInfo accreditationInfo = new AccreditationInfoBuilder()
				.setAccreditation(accreditation)
				.build();
		
		return accreditationInfo;
	}

	static public ILinkage EMFToDomain(Linkage linkageEMF) {
		ILinkage linkage = new LinkageBuilder().setName(linkageEMF.getName()).build();
		return linkage;
	}
}
