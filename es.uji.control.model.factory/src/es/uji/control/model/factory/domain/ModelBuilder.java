package es.uji.control.model.factory.domain;

import java.util.Date;
import java.util.List;

import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.IPerson;
import es.uji.control.domain.people.PersonBuilder.Person;

public class ModelBuilder {

	private Date date;
	private long zoneId;
	private String zoneName;
	private List<IPerson> people;
	private List<IAccreditation> accreditations;
	
	public ModelBuilder setDate(Date date) {
		this.date = date;
		return this;
	}
	
	public ModelBuilder setZoneId(long zoneId) {
		this.zoneId = zoneId;
		return this;
	}
	
	public ModelBuilder setZoneName(String zoneName) {
		this.zoneName = zoneName;
		return this;
	}
	
	public ModelBuilder setPeople(List<IPerson> people) {
		this.people = people;
		return this;
	}
	
	public ModelBuilder setAccreditations(List<IAccreditation> accreditations) {
		this.accreditations = accreditations;
		return this;
	}
	
	public Model build() {
		//TODO:
	}
	
	static private class Model implements IModel {

		@Override
		public Date getDate() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getZoneId() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getZoneName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<IPerson> getPeople() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<IAccreditation> getAccreditations() {
			// TODO Auto-generated method stub
			return null;
		}
	
}
