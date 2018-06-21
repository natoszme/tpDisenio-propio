package dispositivo.gadgets.sensor;

import dispositivo.Dispositivo;

public class SensorHorasEncendido extends Sensor{
	private Dispositivo dispositivo;
	
	public double medir() {
		return dispositivo.horasPrendidoEnMesActual();
	}
}