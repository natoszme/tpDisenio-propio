package tipoDispositivo;
import java.time.LocalDateTime;

import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;

public class DispositivoEstandar implements TipoDispositivo{
	
	public DispositivoEstandar() {}
	
	public boolean esInteligente() {
		return false;
	}
	
	public double puntosPorRegistrar() {
		return 0;
	}
	
	public void convertirAInteligente(Dispositivo dispositivo, long identificadorFabrica, DispositivoConcreto dispositivoConcreto) {
		dispositivo.cambiarTipo(new DispositivoInteligente(identificadorFabrica, dispositivoConcreto));
	}
	
	public boolean estaEncendido() {
		throw new ElMensajeEnviadoNoPuedeSerRespondidoPorUnEstandarException();
	}
	
	public boolean estaApagado() {
		throw new ElMensajeEnviadoNoPuedeSerRespondidoPorUnEstandarException();
	}
	
	public boolean estaEnAhorroEnergia() {
		throw new ElMensajeEnviadoNoPuedeSerRespondidoPorUnEstandarException();
	}

	public void apagar() {
		//no hace nada
	}

	public void encender() {
		//no hace nada
	}
	
	public void ponerEnAhorroDeEnergia() {
		//no hace nada
	}
	
	public void guardarConsumoDeFecha(LocalDateTime fecha, double consumo) {
		//no hace nada
	}

	public double consumoEnLasUltimas(int horas, Dispositivo dispositivo) {
		return dispositivo.estimacionDeConsumoEn(horas);
	}
} 