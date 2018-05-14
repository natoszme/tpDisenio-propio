package dispositivo.actuadores;

import dispositivo.Dispositivo;

public class ActuadorQueApaga extends Actuador{
	
	@Override
	public void actuar(Dispositivo dispositivo){
		
		dispositivo.apagar(); 
		
	}
}
