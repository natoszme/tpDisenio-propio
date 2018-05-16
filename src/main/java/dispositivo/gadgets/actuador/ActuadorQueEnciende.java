package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;

public class ActuadorQueEnciende implements Actuador{

	public void actuarSobre(Dispositivo dispositivo) {
		dispositivo.encender();
	}

}
