package es.uji.control.model.sip;

import java.time.Instant;

public class AsyncModelSIPEvent {
	
	final private Instant instant;
	final private String source;
	final private AsyncModelSIPEventType type;
	final private String msg;
	
	public AsyncModelSIPEvent(Instant instant, String source, AsyncModelSIPEventType type, String msg) {
		super();
		this.instant = instant;
		this.source = source;
		this.type = type;
		this.msg = msg;
	}
	
	public Instant getInstant() {
		return instant;
	}
	
	public String getSource() {
		return source;
	}
	
	public AsyncModelSIPEventType getType() {
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
