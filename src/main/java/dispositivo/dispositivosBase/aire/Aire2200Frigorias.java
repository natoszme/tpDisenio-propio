package dispositivo.dispositivosBase.aire;

import dispositivo.AdaptadorDispositivoSimplex; 
import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import tipoDispositivo.DispositivoInteligente;

public class Aire2200Frigorias extends Dispositivo {

	public Aire2200Frigorias(DispositivoConcreto dispositivoConcreto) {
		super("Aire acondicionado 2200 frigorias", new DispositivoInteligente(dispositivoConcreto), 1.013, new AdaptadorDispositivoSimplex(90, 360));
	}
}