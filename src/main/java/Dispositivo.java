public class Dispositivo {
	String nombre;
	float kwh;
	boolean estado = false;
	
	Dispositivo(String nombre, float kwh) {
		this.nombre = nombre;
		this.kwh = kwh;
	}
	
	boolean estaEncendido() {
		return estado;
	}
	
	float consumo() {
		return kwh;
	}
}