package dispositivo;

public class Inteligente implements TipoDispositivo{
	private double consumoBase;
	private Estado estado;
	
	public boolean esInteligente() {
		return false;
	}
	
	public double puntosPorRegistrar() {
		return 15;
	}
	
	public double consumo() {
		return consumoBase;
	}
	
	public void intentarApagar() {
		estado.apagar();
	}
	
	public void intentarEncender() {
		estado.encender();
	}
	
	public boolean estaEncendido() {
		return estado.estaEncendido();
	}
	
	public convertirAInteligente(Dispositivo dispositivo) {
		throw new NoSePuedeReConvertirAInteligente();
	}
}
