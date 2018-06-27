package dispositivo.gadgets.sensor;

import dispositivo.Dispositivo;

public abstract class Sensor {
	protected Dispositivo dispositivo;
	
	public Sensor(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;		
	}

	public abstract double medir();
}
