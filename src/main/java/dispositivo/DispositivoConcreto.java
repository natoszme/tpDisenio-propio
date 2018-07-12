package dispositivo;

public abstract class DispositivoConcreto {
	
	public abstract void encender();	
	public abstract void apagar();	
	public abstract void ponerEnAhorroDeEnergia();
	public abstract double consumoDuranteLasUltimas(int horas);
	public abstract boolean estaEncendido();
	public abstract boolean estaApagado();
	public abstract boolean estaEnAhorroEnergia();

	public abstract double horasEncendidoEn(double horasDeMesActual);

	public abstract double consumoActual();
}
