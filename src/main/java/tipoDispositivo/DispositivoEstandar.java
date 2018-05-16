package tipoDispositivo;
import dispositivo.Dispositivo;

public class DispositivoEstandar implements TipoDispositivo{
	private double kwPorHora;
	private double horasEncendido;
	
	public DispositivoEstandar() {}
	
	public DispositivoEstandar(double kwPorHora, double horasEncendido) {
		this.kwPorHora = kwPorHora;
		this.horasEncendido = horasEncendido;
	}
	
	public double consumo() {
		return horasEncendido * kwPorHora;
	}
	
	public double getKwPorHora() {
		return kwPorHora;
	}
	
	public double getHorasEncendido(){
		return horasEncendido;
	}
	
	public boolean esInteligente() {
		return false;
	}
	
	public double puntosPorRegistrar() {
		return 0;
	}
	
	public void convertirAInteligente(Dispositivo dispositivo) {
		dispositivo.cambiarTipo(new DispositivoInteligente());
	}
	
	//TODO chequear que pasa con estos dos metodos, que no deberian estar aca
	//encendido se agrega como atributo porque algo hay que devolver...
	public boolean estaEncendido() {
		return false;
	}
	
	public boolean estaEnAhorroEnergia() {
		return false;
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
} 