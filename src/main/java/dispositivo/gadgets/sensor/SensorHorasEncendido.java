package dispositivo.gadgets.sensor;

import javax.persistence.Entity;
import javax.persistence.Transient;

import dispositivo.Dispositivo;

@Entity
public class SensorHorasEncendido extends Sensor {
	
	//TODO mapear a la tabla correspondiente (no a dispositivo)
	@Transient
	protected Dispositivo dispositivo;
	
	public SensorHorasEncendido(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;		
	}
	
	public double medir() {
		return dispositivo.horasPrendidoEnMesActual();
	}
}