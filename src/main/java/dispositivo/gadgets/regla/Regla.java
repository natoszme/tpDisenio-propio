package dispositivo.gadgets.regla;

import java.util.ArrayList;
import java.util.List;

import dispositivo.Dispositivo;
import dispositivo.gadgets.actuador.Actuador;

public abstract class Regla {
	protected Dispositivo dispositivo;	
	protected List<CondicionSobreSensor> condiciones = new ArrayList<>();
	protected List<Actuador> actuadores;
	
	public Regla(List<Actuador> actuadores, List<CondicionSobreSensor> condiciones, Dispositivo dispositivo) {
		validarDispositivoInteligente(dispositivo);
		this.dispositivo = dispositivo;
		this.actuadores = actuadores;
		this.condiciones = condiciones;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public List<CondicionSobreSensor> getCondiciones() {
		return condiciones;
	}

	public List<Actuador> getActuadores() {
		return actuadores;
	}
	
	private void validarDispositivoInteligente(Dispositivo dispositivo) {
		if(!dispositivo.esInteligente()) throw new NoSePuedeUsarReglaSobreDispositivoNoInteligenteException();
	}
	
	public void aplicarSiCumpleCriterio() {
		if(seCumpleCriterio()) {
			actuadores.stream().forEach(actuador -> actuador.actuarSobre(dispositivo));
		}
	}
	
	protected abstract boolean seCumpleCriterio();
	
	public boolean esIgualAMi(Regla otraRegla) {
		return dispositivo == otraRegla.getDispositivo() && condiciones == otraRegla.getCondiciones() && actuadores == otraRegla.getActuadores();
	}

	// Se pueden abstraer los condiciones.stream().X(condicion -> condicion.seCumpleCondicion()); ? (de las subclases)
	
	/*private <Condicion> boolean seCumpleQue(Stream<Condicion> stream, Predicate<? super Condicion> predicate) {
		return stream.allMatch(predicate);
	}*/
}
