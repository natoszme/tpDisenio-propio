package tipoDispositivo;
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
	
	//TODO chequear que pasa con estos dos metodos, que no deberian estar aca
	//encendido se agrega como atributo porque algo hay que devolver...
	public boolean estaEncendido() {
		return false;
	}
	
	public boolean estaApagado() {
		return false;
	}
	
	public boolean estaEnAhorroEnergia() {
		return false;
	}

	public void apagar() {
			
	}

	public void encender() {
		
	}
	
	public void ponerEnAhorroDeEnergia() {
		//no hace nada
	}
} 