package dispositivo.gadgets.regla;

import java.util.ArrayList;
import java.util.List;

import dispositivo.Dispositivo;
import dispositivo.gadgets.Gadget;
import dispositivo.gadgets.actuador.Actuador;

public abstract class Regla extends Gadget{
	protected List<CondicionSobreSensor> condiciones = new ArrayList<>();
	private Actuador actuador;
	Dispositivo dispositivo;
	
	public Regla(Actuador actuador, List<CondicionSobreSensor> condiciones, Dispositivo dispositivo) {
		super(dispositivo);
		this.actuador = actuador;
		this.condiciones = condiciones;
	}
	
	public void aplicarSiCumpleCriterio() {
		if(seCumpleCriterio()) {
			actuador.actuar();
		}
	}
	
	protected abstract boolean seCumpleCriterio();

	// Se pueden abstraer los condiciones.stream().X(condicion -> condicion.seCumpleCondicion()); ? (de las subclases)
	
	/*private <Condicion> boolean seCumpleQue(Stream<Condicion> stream, Predicate<? super Condicion> predicate) {
		return stream.allMatch(predicate);
	}*/
}
