package dispositivo;

public class Dispositivo {
	private String nombre;
	private TipoDispositivo tipoDispositivo;
	private boolean encendido;
	
	public void convertirAInteligente() {
		tipoDispositivo = new Inteligente();
	}
	
	public boolean esInteligente() {
		return tipoDispositivo.esInteligente();
	}
	
	public boolean estaEncendido() {
		return tipoDispositivo.estaEncendido();
	}
	
	public double consumo() {
		return tipoDispositivo.consumo();
	}
	
	public double puntosPorRegistrar() {
		return tipoDispositivo.puntosPorRegistrar();
	}
	
	public void intentarApagar() {
		tipoDispositivo.intentarApagar();
	}
	
	public void intentarEncender() {
		tipoDispositivo.intentarEncender();
	}
	
	public void apagar() {
		tipoDispositivo.apagar();
	}
	
	public void encender() {
		tipoDispositivo.encender();
	}
	
	//este metodo no deberia estar aca...
	public void ponerEnAhorroDeEnergia() {
		tipoDispositivo.ponerEnAhorroDeEnergia();
	}

	//si solo se va a usar para converitrEnInteligente, estaria bueno que se restrinja el tipo a Inteligente
	public void cambiarTipo(TipoDispositivo tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;		
	}
}
