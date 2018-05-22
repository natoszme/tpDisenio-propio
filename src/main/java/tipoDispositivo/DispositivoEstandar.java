package tipoDispositivo;
import java.time.LocalDateTime;

import dispositivo.Dispositivo;
import fabricante.Fabricante;

public class DispositivoEstandar implements TipoDispositivo{
	private double kwPorHora;
	
	public DispositivoEstandar() {}
	
	public DispositivoEstandar(double kwPorHora) {
		this.kwPorHora = kwPorHora;
	}
	
	public double consumoEnLasUltimas(int horas) {
		return horas * kwPorHora;
	}
	
	public double getKwPorHora() {
		return kwPorHora;
	}
	
	public boolean esInteligente() {
		return false;
	}
	
	public double puntosPorRegistrar() {
		return 0;
	}
	
	public void convertirAInteligente(Dispositivo dispositivo, long identificadorFabrica, Fabricante fabricante) {
		dispositivo.cambiarTipo(new DispositivoInteligente(identificadorFabrica, fabricante));
	}
	
	public boolean estaEncendido() {
		throw new ElMensajeEnviadoNoPuedeSerRespondidoPorUnEstandar();
	}
	
	public boolean estaApagado() {
		throw new ElMensajeEnviadoNoPuedeSerRespondidoPorUnEstandar();
	}
	
	public boolean estaEnAhorroEnergia() {
		throw new ElMensajeEnviadoNoPuedeSerRespondidoPorUnEstandar();
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
} 