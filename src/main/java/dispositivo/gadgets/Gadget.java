package dispositivo.gadgets;

import dispositivo.Dispositivo;
import dispositivo.gadgets.regla.NoSePuedeUsarGadgetSobreDispositivoNoInteligenteException;

public abstract class Gadget {
	protected Dispositivo dispositivo;
	
	public Gadget(Dispositivo dispositivo) {
		validarDispositivoInteligente(dispositivo);
		this.dispositivo = dispositivo;
	}
	
	private void validarDispositivoInteligente(Dispositivo dispositivo) {
		if(!dispositivo.esInteligente()) throw new NoSePuedeUsarGadgetSobreDispositivoNoInteligenteException();
	}
}