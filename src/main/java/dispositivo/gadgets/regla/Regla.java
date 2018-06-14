package dispositivo.gadgets.regla;

import java.util.ArrayList;
import java.util.List;

import dispositivo.Dispositivo;
import dispositivo.gadgets.Gadget;
import dispositivo.gadgets.actuador.Actuador;

public abstract class Regla extends Gadget{
	protected List<CondicionSobreSensor> condiciones = new ArrayList<>();
	private Actuador actuador;
	
	public Regla(Actuador actuador, List<CondicionSobreSensor> condiciones, Dispositivo dispositivo) {
		super(dispositivo);
		this.actuador = actuador;
		this.condiciones = condiciones;
		validarMismoDispositivoEnGadgets();
	}
	
	public void aplicarSiCumpleCriterio() {
		if(seCumpleCriterio()) {
			actuador.actuar();
		}
	}
	
	protected abstract boolean seCumpleCriterio();
	
	private void validarMismoDispositivoEnGadgets(){
		if (!condiciones.stream().allMatch(condicion -> condicion.getSensor().esParaDispositivo(dispositivo)) || !actuador.esParaDispositivo(dispositivo)) {
			throw new NoSePuedeAplicarReglaSobreDispositivoQueNoSeaException(dispositivo);
		}
	}

	// Se pueden abstraer los condiciones.stream().X(condicion -> condicion.seCumpleCondicion()); ? (de las subclases)
	
	/*private <Condicion> boolean seCumpleQue(Stream<Condicion> stream, Predicate<? super Condicion> predicate) {
		return stream.allMatch(predicate);
	}*/
}
