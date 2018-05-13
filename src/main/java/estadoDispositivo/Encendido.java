package estadoDispositivo;

import tipoDispositivo.DispositivoInteligente;

public class Encendido implements Estado{
	
	private static Encendido instancia;
	
	public static Encendido getInstance() {
		if(instancia == null) {
			instancia = new Encendido();
		}
		return instancia;
	}
	
	public void encender(DispositivoInteligente dispositivoInteligente) {
		//no hace nada
	}
	
	public void apagar(DispositivoInteligente dispositivoInteligente) {
		dispositivoInteligente.ponerEn(Apagado.getInstance());
	}
	
	public void ponerEnAhorroDeEnergia(DispositivoInteligente dispositivoInteligente) {
		dispositivoInteligente.ponerEn(AhorroEnergia.getInstance());
	}
	
	//TODO alguna forma de evitar esto? es como preguntar por el tipo...
	public boolean estaEncendido() {
		return true;
	}
	
	//idem con este
	public boolean estaEnAhorroDeEnergia() {
		return true;
	}
}
