package simplex;

import dispositivo.Dispositivo;
import dispositivo.gadgets.actuador.Actuador;

public class RestriccionUsoDispositivo {
	private Dispositivo dispositivo;
	double usoMensualMinimo;
	double usoMensualMaximo;
	private Actuador actuadorAlExcederse;
	
	public RestriccionUsoDispositivo(Dispositivo dispositivo, double usoMensualMinimo, double usoMensualMaximo, Actuador actuadorAlExcederse) {
		this.dispositivo = dispositivo;
		this.usoMensualMinimo = usoMensualMinimo;
		this.usoMensualMaximo = usoMensualMaximo;
		this.actuadorAlExcederse = actuadorAlExcederse;
	}

	public boolean esDe(Dispositivo dispositivo) {
		return this.dispositivo.equals(dispositivo);
	}

	public double getUsoMensualMinimo() {
		return usoMensualMinimo;
	}

	public double getUsoMensualMaximo() {
		return usoMensualMaximo;
	}
	
	public Actuador getActuadorAlExcederse() {
		return actuadorAlExcederse;
	}
}
