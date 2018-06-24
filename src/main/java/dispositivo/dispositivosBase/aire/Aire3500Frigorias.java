package dispositivo.dispositivosBase.aire;

import dispositivo.AdaptadorDispositivoSimplex; 
import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import tipoDispositivo.DispositivoInteligente;

public class Aire3500Frigorias extends Dispositivo {

	public Aire3500Frigorias(DispositivoConcreto dispositivoConcreto) {
		super("Aire acondicionado 3500 frigorias", new DispositivoInteligente(dispositivoConcreto), 1.613, new AdaptadorDispositivoSimplex(90, 360));
	}
}