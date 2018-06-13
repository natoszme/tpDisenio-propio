package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;
import dispositivo.gadgets.Gadget;

public abstract class Actuador extends Gadget {

	public Actuador(Dispositivo dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}

	public abstract void actuar();

}
