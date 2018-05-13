package tipoDispositivo;
import dispositivo.Dispositivo;

public class DispositivoEstandar implements TipoDispositivo{
	private double kwPorHora;
	private boolean encendido;
	private double horasEncendido;
	
	public DispositivoEstandar() {}
	
	public DispositivoEstandar(double kwPorHora, boolean encendido, double horasEncendido) {
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
	public boolean estaEncendido() {
		return encendido;
	}
	
	public boolean estaEnAhorroEnergia() {
		return false;
	}

	//TODO estos metodos no deberian estar aca...
	public void apagar() {
		// TODO Auto-generated method stub
		
	}

	public void encender() {
		// TODO Auto-generated method stub
		
	}
} 