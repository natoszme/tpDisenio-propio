public class Dispositivo {
	String nombre;
	double kwPorHora;
	boolean estado;
	double horasEncendido;
	
	Dispositivo(String nombre, double kwPorHora, boolean estado, double horasEncedido) {
		this.nombre = nombre;
		this.kwPorHora = kwPorHora;
		this.estado = estado;
		this.horasEncendido = horasEncedido;
	}
	
	boolean estaEncendido() {
		return estado;
	}
	
	double consumo() {
		return horasEncendido * kwPorHora;
	}
}