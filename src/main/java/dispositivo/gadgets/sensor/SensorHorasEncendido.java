package dispositivo.gadgets.sensor;

import dispositivo.Dispositivo;

public class SensorHorasEncendido extends Sensor {
	
	protected Dispositivo dispositivo;
	
	public SensorHorasEncendido(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;		
	}
	
	public double medir() {
		return dispositivo.horasPrendidoEnMesActual();
	}
}