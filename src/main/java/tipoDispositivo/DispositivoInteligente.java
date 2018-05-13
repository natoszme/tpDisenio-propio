package tipoDispositivo;

import dispositivo.Dispositivo;
import estadoDispositivo.Estado;

public class DispositivoInteligente implements TipoDispositivo{
	private double consumoBase;
	Estado estado;
	
	public DispositivoInteligente() {}
	
	public boolean esInteligente() {
		return false;
	}
	
	public double puntosPorRegistrar() {
		return 15;
	}
	
	public double consumo() {
		return consumoBase;
	}
	
	public void apagar() {
		estado.apagar(this);
	}
	
	public void encender() {
		estado.encender(this);
	}
	
	//TODO ask no se esta pasanod por el dispositivo para hacer este cambio
	public void ponerEnAhorroDeEnergia() {
		estado.ponerEnAhorroDeEnergia(this);
	}
	
	public void cambiarEstado(Estado nuevoEstado) {
		//se podria hacer algo con lambdas para no repetir logica en el estado
	}
	
	public void ponerEn(Estado estado) {
		this.estado = estado;
	}
	
	public boolean estaEncendido() {
		return estado.estaEncendido();
	}
	
	public void convertirAInteligente(Dispositivo dispositivo) {
		throw new NoSePuedeReConvertirAInteligenteException();
	}

	@Override
	public boolean estaEnAhorroEnergia() {
		return estado.estaEnAhorroDeEnergia();
	}
}
