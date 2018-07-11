package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;

public class ActuadorQuePoneEnAhorroDeEnergia implements Actuador{
	public void actuarSobre(Dispositivo dispositivo) {
		dispositivo.ponerEnAhorroDeEnergia();
	}
}
