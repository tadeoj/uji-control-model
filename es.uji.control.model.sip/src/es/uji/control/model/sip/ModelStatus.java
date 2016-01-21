package es.uji.control.model.sip;

import java.time.LocalDateTime;

public class ModelStatus {

	final private LocalDateTime fecha;
	final private int personas;

	public ModelStatus(LocalDateTime fecha, int personas) {
		super();
		this.fecha = fecha;
		this.personas = personas;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public int getPersonas() {
		return personas;
	}

	@Override
	public String toString() {
		return "ModelStatus [fecha=" + fecha + ", personas=" + personas + "]";
	}

}
