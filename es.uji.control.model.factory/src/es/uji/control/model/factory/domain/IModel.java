package es.uji.control.model.factory.domain;

import java.util.Date;
import java.util.List;

import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.IPerson;

public interface IModel {
	
	public Date getDate();
	public List<IPerson> getPeople();
	public List<IAccreditation> getAccreditations();
	
}
