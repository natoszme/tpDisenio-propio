package dispositivo.gadgets.regla;

import dispositivo.Dispositivo;
import dispositivo.gadgets.Gadget;
import dispositivo.gadgets.sensor.Sensor;

public abstract class CondicionSobreSensor implements Gadget{
	private Sensor sensor;
	
	public abstract boolean condicionSobreMedicion(double medicion);
	
	public boolean seCumpleCondicion() {
		return condicionSobreMedicion(sensor.medir());
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public Dispositivo getDispositivo() {
		return getSensor().getDispositivo();
	}
}
