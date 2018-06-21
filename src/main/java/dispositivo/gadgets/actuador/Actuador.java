package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;

public abstract class Actuador {
	
	protected Dispositivo dispositivo;
	
	public Actuador(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public abstract void actuar();
	public Dispositivo getDispositivo() {
		return this.dispositivo;
	}
}
