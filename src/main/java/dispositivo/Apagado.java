package dispositivo;

public class Apagado implements Estado{
	private Dispositivo dispositivo;
	public void apagar() {
		//no hace nada
	}
	
	public void encender() {
		dispositivo.encender();
	}
	
	public boolean estaEncendido() {
		return false;
	}
}
