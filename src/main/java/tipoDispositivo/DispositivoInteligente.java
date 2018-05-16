package tipoDispositivo;

import dispositivo.Dispositivo;
import fabricante.Fabricante;

public class DispositivoInteligente implements TipoDispositivo{
	private long identificadorDeFabrica;
	private Fabricante fabricante;
	
	public DispositivoInteligente(long identificadorDeFabrica, Fabricante fabricante) {
		this.identificadorDeFabrica = identificadorDeFabrica;
		this.fabricante = fabricante;
	}
	
	public boolean esInteligente() {
		return true;
	}
	
	public double puntosPorRegistrar() {
		return 15;
	}
	
	public double consumoEnLasUltimas(int horas) {
		return fabricante.consumoDuranteLasUltimas(horas, identificadorDeFabrica);
	}
	
	public void apagar() {
		fabricante.apagar(identificadorDeFabrica);
	}
	
	public void encender() {
		fabricante.encender(identificadorDeFabrica);
	}

	public void ponerEnAhorroDeEnergia() {
		fabricante.ponerEnAhorroDeEnergia(identificadorDeFabrica);
	}
	
	public boolean estaEncendido() {
		return fabricante.estaEncendido(identificadorDeFabrica);
	}
	
	public boolean estaApagado() {
		return fabricante.estaApagado(identificadorDeFabrica);
	}
	
	public void convertirAInteligente(Dispositivo dispositivo, long identificadorFabrica, Fabricante fabricante) {
		throw new NoSePuedeReConvertirAInteligenteException();
	}

	public boolean estaEnAhorroEnergia() {
		return fabricante.estaEnAhorroEnergia(identificadorDeFabrica);
	}
}
