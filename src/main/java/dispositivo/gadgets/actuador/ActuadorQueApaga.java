package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;
import dispositivo.gadgets.Gadget;

public class ActuadorQueApaga extends Gadget implements Actuador {
	public ActuadorQueApaga(Dispositivo dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}

	public void actuar() {
		dispositivo.apagar();
	}
}
