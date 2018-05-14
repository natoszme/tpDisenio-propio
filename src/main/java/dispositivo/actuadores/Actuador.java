package dispositivo.actuadores;

import dispositivo.Dispositivo;

public abstract class Actuador {
	
	//TODO hay que chequear que los dispositivos sean siempre inteligentes
	
	public void validarInteligente(Dispositivo dispositivo) throws Exception {
		if(!dispositivo.esInteligente()) {
			throw new Exception("Los actuadores solo se deben comunicar con dispositivos inteligentes");
		}
	}
	
	public abstract void actuar(Dispositivo dispositivo); 

}
/* TODO
 * Hay que pensasr bien como va a ser la interfaz que va a estar en el medio de esta y el dispositivo por que tiene 
 * que poder manejar como se van a manejar los distintos dispositivos según el fabricante
 * (dice que recibe el ID del fabricante en el intercambio de mensajes).
 * */
 