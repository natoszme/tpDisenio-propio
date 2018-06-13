package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;

public class ActuadorQueApaga extends Actuador {
	public ActuadorQueApaga(Dispositivo dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}

	public void actuar() {
		dispositivo.apagar();
	}
}
