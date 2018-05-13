package dispositivo;

public class AhorroEnergia implements Estado{
	private Dispositivo dispositivo;
	
	public void apagar() {
		dispositivo.apagar();
	}
	
	public void encender() {
		dispositivo.ponerEnAhorroDeEnergia();
	}
	
	public boolean estaEncendido() {
		//TODO se asume
		return true;
	}
}
