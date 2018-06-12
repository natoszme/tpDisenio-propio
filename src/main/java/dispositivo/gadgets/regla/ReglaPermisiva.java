package dispositivo.gadgets.regla;

import java.util.List;

import dispositivo.Dispositivo;
import dispositivo.gadgets.actuador.Actuador;

public class ReglaPermisiva extends Regla{
	public ReglaPermisiva(Actuador actuador, List<CondicionSobreSensor> condiciones, Dispositivo dispositivo) {
		super(actuador, condiciones, dispositivo);
		// TODO Auto-generated constructor stub
	}

	protected boolean seCumpleCriterio() {
		return condiciones.stream().anyMatch(condicion -> condicion.seCumpleCondicion());
	}
}