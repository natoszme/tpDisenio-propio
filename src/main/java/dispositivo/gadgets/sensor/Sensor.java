package dispositivo.gadgets.sensor;

import dispositivo.Dispositivo;

public abstract class Sensor {
	private Dispositivo dispositivo;

	public abstract double medir();
	
	public Dispositivo getDispositivo() {
		return dispositivo;
	}
}
