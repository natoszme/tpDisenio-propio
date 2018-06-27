package dispositivo.dispositivosBase.plancha;

import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import tipoDispositivo.DispositivoInteligente;

public class PlanchaAVapor extends Dispositivo {

	public PlanchaAVapor(DispositivoConcreto dispositivoConcreto) {
		super("Plancha convencional", new DispositivoInteligente(dispositivoConcreto), 0.75);
	}
}