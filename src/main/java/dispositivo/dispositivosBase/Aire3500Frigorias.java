package dispositivo.dispositivosBase;

import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import tipoDispositivo.DispositivoInteligente;

public class Aire3500Frigorias extends Dispositivo {

	public Aire3500Frigorias(DispositivoConcreto dispositivoConcreto) {
		super("Aire acondicionado 3500 frigorias", new DispositivoInteligente(dispositivoConcreto), 1.613);
	}
}
