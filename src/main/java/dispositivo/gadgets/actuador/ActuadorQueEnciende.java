package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;
import dispositivo.gadgets.Gadget;

public class ActuadorQueEnciende extends Gadget implements Actuador{

	public ActuadorQueEnciende(Dispositivo dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}

	public void actuar() {
		dispositivo.encender();
	}

}
