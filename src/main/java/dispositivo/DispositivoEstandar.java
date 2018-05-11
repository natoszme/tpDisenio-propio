package dispositivo;

public class DispositivoEstandar implements Dispositivo{
	String nombre;
	double kwPorHora;
	double horasEncendido;
	public DispositivoEstandar() {//json
		
	}
	
	 
	
	public DispositivoEstandar(String nombre, double kwPorHora, double horasEncendido) {
		this.nombre = nombre;
		this.kwPorHora = kwPorHora;
		this.horasEncendido = horasEncendido;
	}

//metodos de la interfaz	
	
	public double consumo() {
		return horasEncendido * kwPorHora;
	}
	 public String getNombre() {
		return nombre;
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
	public boolean estaEncendido() { 
		return false;
	}
//--------------------------------------
}
