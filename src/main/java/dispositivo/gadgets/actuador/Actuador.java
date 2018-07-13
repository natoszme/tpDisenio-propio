package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;
import dispositivo.gadgets.regla.Gadget;

public abstract class Actuador extends Gadget{

	public abstract void actuarSobre(Dispositivo dispositivo);
}
