package dispositivo.gadgets.sensor;

import dispositivo.Dispositivo;

public class SensorHorasEncendido extends Sensor {
	
	public SensorHorasEncendido(Dispositivo dispositivo) {
		super(dispositivo);
	}
	
	public double medir() {
		return dispositivo.horasPrendidoEnMesActual();
	}
}