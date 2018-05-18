package dispositivo.gadgets.regla;

import dispositivo.gadgets.sensor.Sensor;

public abstract class CondicionSobreSensor {
	private Sensor sensor;
	
	public abstract boolean seCumpleCondicion();
}
