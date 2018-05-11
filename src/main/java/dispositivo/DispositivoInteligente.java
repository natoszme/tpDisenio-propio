package dispositivo;
public class Dispositivo {
	String nombre;
	double kwPorHora;
	boolean encendido;
	double horasEncendido;
	
	public Dispositivo() {
		
	}
	
	public Dispositivo(String nombre, double kwPorHora, boolean estado, double horasEncendido) {
		this.nombre = nombre;
		this.kwPorHora = kwPorHora;
		this.encendido = estado;
		this.horasEncendido = horasEncendido;
	}
	
	public boolean estaEncendido() {
		return encendido;
	}
	
	public double consumo() {
		return horasEncendido * kwPorHora;
	}
	
	public String getNombre() {
		return nombre;
	}
	public double getKwPorHora() {
		return kwPorHora;
	}
	
	public boolean isEncendido() {
		return encendido;
	}
	
	public double getHorasEncendido(){
		return horasEncendido;
	}
} 