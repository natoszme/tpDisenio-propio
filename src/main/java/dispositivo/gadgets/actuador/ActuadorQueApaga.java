package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;

public class ActuadorQueApaga extends Actuador {

	public void actuarSobre(Dispositivo dispositivo) {
		dispositivo.apagar();
	}
}
