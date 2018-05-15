package actuador;

import dispositivo.Dispositivo;

public class ActuadorQueApaga implements Actuador{
	public void actuarSobre(Dispositivo dispositivo) {
		dispositivo.apagar();
	}
}
