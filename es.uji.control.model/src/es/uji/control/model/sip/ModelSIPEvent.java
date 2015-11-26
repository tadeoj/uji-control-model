package es.uji.control.model.sip;

import java.time.Instant;

public class ModelSIPEvent {
	
	final private Instant instant;
	final private ModelSIPEventSource source;
	final private ModelSIPEventType type;
	final private String msg;
	
	public ModelSIPEvent(Instant instant, ModelSIPEventSource source, ModelSIPEventType type, String msg) {
		super();
		this.instant = instant;
		this.source = source;
		this.type = type;
		this.msg = msg;
	}
	
	public Instant getInstant() {
		return instant;
	}
	
	public ModelSIPEventSource getSource() {
		return source;
	}
	
	public ModelSIPEventType getType() {
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
