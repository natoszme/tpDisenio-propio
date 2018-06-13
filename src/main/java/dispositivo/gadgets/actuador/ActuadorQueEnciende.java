package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;

public class ActuadorQueEnciende extends Actuador{

	public ActuadorQueEnciende(Dispositivo dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}

	public void actuar() {
		dispositivo.encender();
	}

}
