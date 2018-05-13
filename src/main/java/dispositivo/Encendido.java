package dispositivo;

public class Encendido implements Estado{
	private Dispositivo dispositivo;
	public void encender() {
		//no hace nada
	}
	
	public void apagar() {
		dispositivo.apagar();
	}
	
	//TODO alguna forma de evitar esto? es como preguntar por el tipo...
	public boolean estaEncendido() {
		return true;
	}
}
