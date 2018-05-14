package dispositivo.sensores;

import dispositivo.Dispositivo;

public abstract class Sensor<TipoMedicion>  {
	
	public abstract TipoMedicion medir(Dispositivo dispositivo);
	
}
