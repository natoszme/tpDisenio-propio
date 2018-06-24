package dispositivo.dispositivosBase.computadora;

import dispositivo.AdaptadorDispositivoSimplex; 
import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import tipoDispositivo.DispositivoInteligente;

public class ComputadoraDeEscritorio extends Dispositivo {

	public ComputadoraDeEscritorio(DispositivoConcreto dispositivoConcreto) {
		super("Computadora de escritorio", new DispositivoInteligente(dispositivoConcreto), 0.4, new AdaptadorDispositivoSimplex(60, 360));
	}
}