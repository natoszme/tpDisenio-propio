package dispositivo.gadgets.regla;

import dispositivo.Dispositivo;

public class NoSePuedeAplicarReglaSobreDispositivoQueNoSeaException extends RuntimeException {
	public NoSePuedeAplicarReglaSobreDispositivoQueNoSeaException(Dispositivo dispositivo) {
		super(dispositivo.getNombre());
	}
}
