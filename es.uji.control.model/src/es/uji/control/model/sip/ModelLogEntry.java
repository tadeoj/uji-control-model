package es.uji.control.model.sip;

import java.time.Instant;

public class ModelLogEntry {
	
	final private Instant instant;
	final private ModelLogSource source;
	final private ModelLogType type;
	final private String msg;
	
	public ModelLogEntry(Instant instant, ModelLogSource source, ModelLogType type, String msg) {
		super();
		this.instant = instant;
		this.source = source;
		this.type = type;
		this.msg = msg;
	}
	
	public Instant getInstant() {
		return instant;
	}
	
	public ModelLogSource getSource() {
		return source;
	}
	
	public ModelLogType getType() {
		return type;
	}
	
	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return "AsyncModelSIPEvent [instant=" + instant + ", source=" + source + ", type=" + type + ", msg=" + msg + "]";
	}
	
}
