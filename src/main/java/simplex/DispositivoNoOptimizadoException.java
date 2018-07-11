package simplex;

import dispositivo.Dispositivo;

public class DispositivoNoOptimizadoException extends RuntimeException {

	public DispositivoNoOptimizadoException(Dispositivo dispositvo) {
		super(dispositvo.getNombre());
	}

}
