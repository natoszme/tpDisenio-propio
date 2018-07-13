package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;

public class ActuadorQueEnciende extends Actuador{

	public void actuarSobre(Dispositivo dispositivo) {
		dispositivo.encender();
	}

}
