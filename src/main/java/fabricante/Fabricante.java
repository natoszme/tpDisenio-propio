package fabricante;

public abstract class Fabricante {
	
	public abstract void encender(long identificadorDeFabrica);	
	public abstract void apagar(long identificadorDeFabrica);	
	public abstract void ponerEnAhorroDeEnergia(long identificadorDeFabrica);
	public abstract double consumoDuranteLasUltimas(long identificadorDeFabrica, int horas);
}
