package tipoDispositivo;

import dispositivo.Dispositivo;
import estadoDispositivo.Estado;
import fabricante.Fabricante;

public class DispositivoInteligente implements TipoDispositivo{
	private double consumoBase;
	private Estado estado;
	private long identificadorDeFabrica;
	private Fabricante fabricante;
	
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
	
	public double consumoDuranteLasUltimas(int horas) {
		return fabricante.consumoDuranteLasUltimas(identificadorDeFabrica, horas);
	}
	
	public void apagar() {
		estado.apagar(this);
		fabricante.apagar(identificadorDeFabrica);
	}
	
	public void encender() {
		estado.encender(this);
		fabricante.encender(identificadorDeFabrica);
	}

	public void ponerEnAhorroDeEnergia() {
		estado.ponerEnAhorroDeEnergia(this);
		fabricante.ponerEnAhorroDeEnergia(identificadorDeFabrica);
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

	public boolean estaEnAhorroEnergia() {
		return estado.estaEnAhorroDeEnergia();
	}
}
