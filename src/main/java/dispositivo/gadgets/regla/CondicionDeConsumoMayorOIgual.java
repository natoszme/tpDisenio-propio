package dispositivo.gadgets.regla;

import dispositivo.gadgets.sensor.Sensor;

public class CondicionDeConsumoMayorOIgual extends CondicionSobreSensor {
	
	private double factorDeComparacion;
	
	public CondicionDeConsumoMayorOIgual(double factorDeComparacion, Sensor sensor) {
		super(sensor);
		this.factorDeComparacion = factorDeComparacion;
	}
	
	public boolean condicionSobreMedicion(double medicion) {
		return medicion >= factorDeComparacion;
	}
}