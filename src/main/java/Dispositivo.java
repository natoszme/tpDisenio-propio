public class Dispositivo {
	String nombre;
	double kwh;
	boolean estado = false;
	
	Dispositivo(String nombre, double kwh) {
		this.nombre = nombre;
		this.kwh = kwh;
	}
	
	boolean estaEncendido() {
		return estado;
	}
	
	double consumo() {
		return kwh;
	}
}