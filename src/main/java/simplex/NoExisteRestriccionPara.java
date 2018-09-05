package simplex;

import dispositivo.Dispositivo;

public class NoExisteRestriccionPara extends RuntimeException {

	public NoExisteRestriccionPara(Dispositivo dispositivo) {
		super(dispositivo.getNombre());
	}	
}
