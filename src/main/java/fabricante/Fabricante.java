package fabricante;

public interface Fabricante {
	
	public void encender(long identificadorDeFabrica);	
	public void apagar(long identificadorDeFabrica);	
	public void ponerEnAhorroDeEnergia(long identificadorDeFabrica);
	public double consumoDuranteLasUltimas(int horas, long identificadorDeFabrica);
	public boolean estaEncendido(long identificadorDeFabrica);
	public boolean estaApagado(long identificadorDeFabrica);
	public boolean estaEnAhorroEnergia(long identificadorDeFabrica);
}
