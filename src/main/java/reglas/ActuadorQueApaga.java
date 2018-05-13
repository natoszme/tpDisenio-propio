package reglas;

import dispositivo.Dispositivo;

public class ActuadorQueApaga extends Actuador{
	public void actuarSobre(Dispositivo dispositivo) {
		dispositivo.apagar();
	}
}
