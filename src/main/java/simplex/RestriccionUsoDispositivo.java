package simplex;

import dispositivo.Dispositivo;

public class RestriccionUsoDispositivo {
	private Dispositivo dispositivo;
	double usoMensualMinimo;
	double usoMensualMaximo;
	
	public RestriccionUsoDispositivo(Dispositivo dispositivo, double usoMensualMinimo, double usoMensualMaximo) {
		this.dispositivo = dispositivo;
		this.usoMensualMinimo = usoMensualMinimo;
		this.usoMensualMaximo = usoMensualMaximo;
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
}
