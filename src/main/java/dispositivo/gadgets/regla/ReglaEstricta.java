package dispositivo.gadgets.regla;

import java.util.List;

import dispositivo.Dispositivo;
import dispositivo.gadgets.actuador.Actuador;

public class ReglaEstricta extends Regla{
	public ReglaEstricta(List<Actuador> actuadores, List<CondicionSobreSensor> condiciones, Dispositivo dispositivo) {
		super(actuadores, condiciones, dispositivo);
		// TODO Auto-generated constructor stub
	}

	protected boolean seCumpleCriterio() {
		return condiciones.stream().allMatch(condicion -> condicion.seCumpleCondicion());
	}
}
