package dispositivo.gadgets.sensor;

import dispositivo.Dispositivo;
import dispositivo.gadgets.Gadget;

public abstract class Sensor extends Gadget{
	public Sensor(Dispositivo dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}

	public abstract double medir();
}
