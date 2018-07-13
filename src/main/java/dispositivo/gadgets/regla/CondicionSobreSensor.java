package dispositivo.gadgets.regla;

import dispositivo.gadget.Gadget;
import dispositivo.gadgets.sensor.Sensor;

public abstract class CondicionSobreSensor extends Gadget{
	private Sensor sensor;
	
	public CondicionSobreSensor(Sensor sensor) {
		this.sensor = sensor;		
	}
	
	public abstract boolean condicionSobreMedicion(double medicion);
	
	public boolean seCumpleCondicion() {
		return condicionSobreMedicion(sensor.medir());
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	@Override
	public boolean esIgualA(Gadget gadget) {
		return sensor == ((CondicionSobreSensor)gadget).getSensor();
	}
}