package estadoDispositivo;

import tipoDispositivo.DispositivoInteligente;

public class Apagado implements Estado{
	
	private static Apagado instancia;
	
	public static Apagado getInstance() {
		if(instancia == null) {
			instancia = new Apagado();
		}
		return instancia;
	}
	
	public void apagar(DispositivoInteligente dispositivoInteligente) {
		//no hace nada
	}
	
	public void encender(DispositivoInteligente dispositivoInteligente) {
		dispositivoInteligente.ponerEn(Encendido.getInstance());
	}
	
	public void ponerEnAhorroDeEnergia(DispositivoInteligente dispositivoInteligente) {
		throw new NoSePuedePonerEnAhorroUnDispositivoApagadoException();
	}
	
	//TODO revisar si se puede evitar
	public boolean estaEncendido() {
		return false;
	}
	
	//idem aca
	public boolean estaEnAhorroDeEnergia() {
		return true;
	}
}
