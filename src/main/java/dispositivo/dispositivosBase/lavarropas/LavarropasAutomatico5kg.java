package dispositivo.dispositivosBase.lavarropas;

import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import tipoDispositivo.DispositivoInteligente;

public class LavarropasAutomatico5kg extends Dispositivo {

	public LavarropasAutomatico5kg(DispositivoConcreto dispositivoConcreto) {
		super("Lavarropas automatico de 5kg", new DispositivoInteligente(dispositivoConcreto), 0.175);
	}
}