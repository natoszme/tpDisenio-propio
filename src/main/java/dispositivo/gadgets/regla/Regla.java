package dispositivo.gadgets.regla;

import java.util.ArrayList;
import java.util.List;

import dispositivo.Dispositivo;
import dispositivo.gadgets.actuador.Actuador;
import dispositivo.gadgets.sensor.Sensor;

public abstract class Regla {
	protected List<Sensor> sensores = new ArrayList<>();
	private Actuador actuador;
	
	public Regla(Actuador actuador) {
		this.actuador = actuador;
	}
	
	public abstract boolean seCumpleCondicion();
	
	public void setActuador(Actuador actuador) {
		this.actuador = actuador;		
	}
	
	private void validarDispositivoInteligente(Dispositivo dispositivo) {
		if(!dispositivo.esInteligente()) throw new NoSePuedeEvaluarReglaADispositivoNoInteligenteException();
	}
	
	public void evaluarPara(Dispositivo dispositivo) {
		validarDispositivoInteligente(dispositivo);
		if(this.seCumpleCondicion()) {
			actuador.actuarSobre(dispositivo);
		}
	}
}
