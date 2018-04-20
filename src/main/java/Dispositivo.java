
public class Dispositivo {
	String nombre;
	double kwPorHora;
	boolean encendido;
	double horasEncendido;	
	
	public Dispositivo(String nombre, double kwPorHora, boolean encendido, double horasEncendido) {
		this.nombre = nombre;
		this.kwPorHora = kwPorHora;
		this.encendido = encendido;
		this.horasEncendido = horasEncendido;
	}

	public boolean estaEncendido() { 
		return encendido;
	}
	
	public double consumo() {
		return horasEncendido * kwPorHora;
	}
}
