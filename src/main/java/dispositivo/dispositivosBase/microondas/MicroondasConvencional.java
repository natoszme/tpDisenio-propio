package dispositivo.dispositivosBase.microondas;

import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import simplex.RestriccionUsoDispositivo;
import tipoDispositivo.DispositivoInteligente;

public class MicroondasConvencional extends Dispositivo {

	public MicroondasConvencional(DispositivoConcreto dispositivoConcreto) {
		super("Microondas convencional", new DispositivoInteligente(dispositivoConcreto), 0.64);
	}
}