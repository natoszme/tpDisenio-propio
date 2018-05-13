package estadoDispositivo;

import tipoDispositivo.DispositivoInteligente;

public interface Estado {
	public void apagar(DispositivoInteligente dispositivoInteligente);
	public void encender(DispositivoInteligente dispositivoInteligente);
	public void ponerEnAhorroDeEnergia(DispositivoInteligente dispositivoInteligente);
	public boolean estaEncendido();
	public boolean estaEnAhorroDeEnergia();
}
