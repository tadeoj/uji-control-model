package es.uji.control.model.sip.domain;

import java.util.Date;
import java.util.List;

import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.IPerson;

public class ModelBuilder {

	private Date date;
	private long zoneId = -1;
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
		if (date == null) throw new IllegalStateException("date isn't defined");
		if (zoneId == -1) throw new IllegalStateException("zoneId isn't defined");
		if (zoneName == null) throw new IllegalStateException("zoneName isn't defined");
		if (people == null) throw new IllegalStateException("people isn't defined");
		if (accreditations == null) throw new IllegalStateException("accreditations isn't defined");
		return new Model(date, zoneId, zoneName, people, accreditations);
	}

	static private class Model implements IModel {

		private final Date date;
		private final long zoneId;
		private final String zoneName;
		private final List<IPerson> people;
		private final List<IAccreditation> accreditation;

		private Model(Date date, long zoneId, String zoneName, List<IPerson> people,
				List<IAccreditation> accreditation) {
			super();
			this.date = date;
			this.zoneId = zoneId;
			this.zoneName = zoneName;
			this.people = people;
			this.accreditation = accreditation;
		}

		@Override
		public Date getDate() {
			return date;
		}

		@Override
		public long getZoneId() {
			return zoneId;
		}

		@Override
		public String getZoneName() {
			return zoneName;
		}

		@Override
		public List<IPerson> getPeople() {
			return people;
		}

		@Override
		public List<IAccreditation> getAccreditations() {
			return accreditation;
		}
	}
}
