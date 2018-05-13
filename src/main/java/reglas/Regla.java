package reglas;

import java.util.ArrayList;
import java.util.List;

import dispositivo.Dispositivo;

public abstract class Regla {
	protected List<Sensor> sensores = new ArrayList<>();
	private Actuador actuador;
	
	public Regla(Actuador actuador) {
		this.actuador = actuador;
	}
	
	public abstract boolean seCumpleCondicion();
	
	public void evaluarPara(Dispositivo dispositivo) {
		if(this.seCumpleCondicion()) {
			actuador.actuarSobre(dispositivo);
		}
	}
}
