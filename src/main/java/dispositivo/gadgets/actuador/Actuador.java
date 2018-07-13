package dispositivo.gadgets.actuador;

import dispositivo.Dispositivo;
import dispositivo.gadget.Gadget;

public abstract class Actuador extends Gadget{

	public abstract void actuarSobre(Dispositivo dispositivo);
}
