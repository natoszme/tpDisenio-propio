package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;
import dispositivo.gadgets.Gadget;

public abstract class Actuador implements Gadget {
	
	protected Dispositivo dispositivo;
	
	public Actuador(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public abstract void actuar();
	public Dispositivo getDispositivo() {
		return this.dispositivo;
	}
}
