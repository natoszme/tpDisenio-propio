package dispositivo.dispositivosBase.ventilador;

import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import simplex.RestriccionUsoDispositivo;
import tipoDispositivo.DispositivoInteligente;

public class VentiladorDeTecho extends Dispositivo {

	public VentiladorDeTecho(DispositivoConcreto dispositivoConcreto) {
		super("Ventilador de techo", new DispositivoInteligente(dispositivoConcreto), 0.06, new RestriccionUsoDispositivo(120, 360));
	}
}