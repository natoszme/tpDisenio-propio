package dispositivo.gadgets.regla;

import java.util.ArrayList;
import java.util.List;

import dispositivo.Dispositivo;
import dispositivo.gadgets.actuador.Actuador;

public abstract class Regla {
	protected List<CondicionSobreSensor> condiciones = new ArrayList<>();
	private Actuador actuador;
	
	public Regla(Actuador actuador, List<CondicionSobreSensor> condiciones) {
		this.actuador = actuador;
		this.condiciones = condiciones;
	}
	
	public void setActuador(Actuador actuador) {
		this.actuador = actuador;		
	}
	
	public void setCondiciones(List<CondicionSobreSensor> condiciones) {
		this.condiciones = condiciones;		
	}
	
	private void validarDispositivoInteligente(Dispositivo dispositivo) {
		if(!dispositivo.esInteligente()) throw new NoSePuedeEvaluarReglaADispositivoNoInteligenteException();
	}
	
	/*private boolean seCumplenLasSiguientesCondiciones(Dispositivo dispositivo, Predicate<List<CondicionSobreSensor>> metodo) {
		validarDispositivoInteligente(dispositivo);
		if (metodo.condiciones.stream())) {
			actuador.actuarSobre(dispositivo);
		}
	}*/
	
	public void evaluarSiSeCumpleSegunCriterio(Dispositivo dispositivo, boolean condicion) {
		validarDispositivoInteligente(dispositivo);
		if(condicion) {
			actuador.actuarSobre(dispositivo);
		}
	}
	
	public void evaluarTodasSobre(Dispositivo dispositivo) {		
		evaluarSiSeCumpleSegunCriterio(dispositivo, seCumplenTodas());
	}
	
	public void evaluarAlgunaSobre(Dispositivo dispositivo) {
		evaluarSiSeCumpleSegunCriterio(dispositivo, seCumpleAlguna());
	}
	
	//se pueden abstraer los condiciones.stream().X(condicion -> condicion.seCumpleCondicion());?
	public boolean seCumplenTodas() {
		return condiciones.stream().allMatch(condicion -> condicion.seCumpleCondicion());
	}
	
	public boolean seCumpleAlguna() {
		return condiciones.stream().anyMatch(condicion -> condicion.seCumpleCondicion());
	}
}
