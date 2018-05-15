package estadoDispositivo;

import tipoDispositivo.DispositivoInteligente;

public class AhorroEnergia implements Estado{
	private static AhorroEnergia instancia;
	
	public static AhorroEnergia getInstance(){
		if(instancia == null) {
			instancia = new AhorroEnergia();
		}
		return instancia;
	}
	
	public void apagar(DispositivoInteligente dispositivoInteligente) {
		dispositivoInteligente.ponerEn(Apagado.getInstance());
	}
	
	public void encender(DispositivoInteligente dispositivoInteligente) {
		dispositivoInteligente.ponerEn(Encendido.getInstance());
	}
	
	public void ponerEnAhorroDeEnergia(DispositivoInteligente dispositivoInteligente) {
		//no hace nada
	}
	
	public boolean estaEncendido() {
		//TODO se asume
		return true;
	}

	//idem aca
	public boolean estaEnAhorroDeEnergia() {
		return true;
	}
}
