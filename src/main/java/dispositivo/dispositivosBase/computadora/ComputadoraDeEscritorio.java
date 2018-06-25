package dispositivo.dispositivosBase.computadora;

import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import simplex.RestriccionUsoDispositivo;
import tipoDispositivo.DispositivoInteligente;

public class ComputadoraDeEscritorio extends Dispositivo {

	public ComputadoraDeEscritorio(DispositivoConcreto dispositivoConcreto) {
		super("Computadora de escritorio", new DispositivoInteligente(dispositivoConcreto), 0.4, new RestriccionUsoDispositivo(60, 360));
	}
}