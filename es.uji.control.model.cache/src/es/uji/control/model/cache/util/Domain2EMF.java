package es.uji.control.model.cache.util;

import java.util.List;

import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.IPerson;
import es.uji.control.model.emf.sip.Cards;
import es.uji.control.model.emf.sip.Model;
import es.uji.control.model.emf.sip.Persons;
import es.uji.control.model.emf.sip.SipFactory;
import es.uji.control.model.emf.sip.impl.SipPackageImpl;
import es.uji.control.model.factory.domain.IModel;

public class Domain2EMF {

	static public Model covert(IModel domain) throws ModelConverterException {

		if (domain != null) {
			SipPackageImpl.init();
			SipFactory factory = SipFactory.eINSTANCE;
			Model model = factory.createModel();

			// Se incluye la fecha del modelo
			model.setDate(domain.getDate());
			
			// Se incluye el identificador de la zona y el nombre
			model.setZoneId(domain.getZoneId());
			model.setZoneName(domain.getZoneName());
			
			List<IAccreditation> accreditations = domain.getAccreditations();
			List<IPerson> people = domain.getPeople();
			
			// Se recorren las tarjetas y se almacenan en la relación con el modelo EMF
			for (IAccreditation accreditation : accreditations) {

				// Se genera una instancia del objeto tarjeta del modelo EMF.
				Cards card = factory.createCards();
				card.setDescription(accreditation.getType().toString());
				card.setPerId(perTarjeta.getPerId());
				card.setSerialNumber(perTarjeta.getSerialNumber());
				card.setCancelationDate(perTarjeta.getFCancelacion());
				card.setCreationDate(perTarjeta.getFCreacion());
				card.setIssueDate(perTarjeta.getFEmision());

				model.getModelCardsList().add(card);
			}

			Persons person = null;

			// Se recorren las personas y se almacenan todas las relaciones con
			// el modelo, con las tarjetas, y con las autorizaciones
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
				// person.setLink(scuVPersona.getVinculo());

				// Se recorre la lista de tarjetas
				for (ScuVTarjeta scuVTarjeta : listScuVTarjeta) {

					if (person.getId() == scuVTarjeta.getPerId()) {
						// Se crea una instancia del objeto Cards del modelo EMF
						Cards card = factory.createCards();

						// Se completan los campos del objeto Cards del modelo
						// EMF
						card.setId(scuVTarjeta.getTarjetaId());
						card.setPerId(scuVTarjeta.getPerId());
						card.setCreationDate(scuVTarjeta.getFCreacion());
						card.setIssueDate(scuVTarjeta.getFEmision());
						card.setCancelationDate(scuVTarjeta.getFCancelacion());
						card.setDescription(scuVTarjeta.getDescripcion());
						card.setSerialNumber(scuVTarjeta.getSerialNumber());

						// Se incluye la lista de tarjetas relacionadas con la
						// persona
						person.getCardsList().add(card);
					}
				}

				// Se incluye la persona en el modelo.
				model.getModelPersonsList().add(person);
			}
			return model;
		} else {
			throw new ModelConverterException("El modelo que se quiere convertir esta vacio.");
		}
	}

}
