package dispositivo.dispositivosBase.lampara;

import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import tipoDispositivo.DispositivoInteligente;

public class LamparaDe20W extends Dispositivo {

	public LamparaDe20W(DispositivoConcreto dispositivoConcreto) {
		super("Lampara de 20 W", new DispositivoInteligente(dispositivoConcreto), 0.02);
	}
}