package dispositivo.dispositivosBase.ventilador;

import dispositivo.AdaptadorDispositivoSimplex; 
import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import tipoDispositivo.DispositivoInteligente;

public class TelevisorLed40 extends Dispositivo {

	public TelevisorLed40(DispositivoConcreto dispositivoConcreto) {
		super("Televisor LED 40", new DispositivoInteligente(dispositivoConcreto), 0.08, new AdaptadorDispositivoSimplex(90, 360));
	}
}