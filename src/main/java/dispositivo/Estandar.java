package dispositivo;
public class Estandar implements TipoDispositivo{
	double kwPorHora;
	double horasEncendido;
	
	public Estandar() {
		
	}
	
	public Estandar(double kwPorHora, boolean estado, double horasEncendido) {
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
	
	//se estan forzando estos dos metodos por la interfaz
	public void intentarApagar(){
		throw new UnDispositivoEstandarNoPuedeApagarse();
	}
	
	public void intentarEncender(){
		throw new UnDispositivoEstandarNoPuedeEncenderse();
	}
	
	public void convertirAInteligente(Dispositivo dispositivo) {
		dispositivo.cambiarTipo(new Inteligente());
	}
} 