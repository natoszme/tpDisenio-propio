package dispositivo.reglas;

import dispositivo.Dispositivo;
import dispositivo.actuadores.Actuador;

public abstract class Regla {
	
	
	/*Recibe el actuador por parametro para que sea mas flexible, por ejemplo que la regla sea "si son las 10.00hs" -> que haga 
	 * determinada acción que va a ser dada por el actuador que recibe
	 * */
	void evaluarPara(Dispositivo dispositivo, Actuador actuador) { 
		if(this.cumpleRegla(dispositivo)) {
			actuador.actuar(dispositivo);
		}
	}
	
	//Métodos abstractos
	
	public abstract boolean cumpleRegla(Dispositivo dispositivo);
}

