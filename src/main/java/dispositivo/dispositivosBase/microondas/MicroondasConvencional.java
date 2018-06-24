package dispositivo.dispositivosBase.microondas;

import dispositivo.AdaptadorDispositivoSimplex; 
import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import tipoDispositivo.DispositivoInteligente;

public class MicroondasConvencional extends Dispositivo {

	public MicroondasConvencional(DispositivoConcreto dispositivoConcreto) {
		super("Microondas convencional", new DispositivoInteligente(dispositivoConcreto), 0.64, new AdaptadorDispositivoSimplex(3, 15));
	}
}