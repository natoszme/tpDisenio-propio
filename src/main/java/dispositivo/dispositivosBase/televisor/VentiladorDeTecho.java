package dispositivo.dispositivosBase.televisor;

import dispositivo.AdaptadorDispositivoSimplex; 
import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import tipoDispositivo.DispositivoInteligente;

public class VentiladorDeTecho extends Dispositivo {

	public VentiladorDeTecho(DispositivoConcreto dispositivoConcreto) {
		super("Ventilador de techo", new DispositivoInteligente(dispositivoConcreto), 0.06, new AdaptadorDispositivoSimplex(120, 360));
	}
}