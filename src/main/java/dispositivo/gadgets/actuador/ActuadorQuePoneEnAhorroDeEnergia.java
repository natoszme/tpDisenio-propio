package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;

public class ActuadorQuePoneEnAhorroDeEnergia extends Actuador{
	public void actuarSobre(Dispositivo dispositivo) {
		dispositivo.ponerEnAhorroDeEnergia();
	}
}
