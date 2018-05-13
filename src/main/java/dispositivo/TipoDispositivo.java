package dispositivo;

public interface TipoDispositivo {
	public double puntosPorRegistrar();
	public boolean esInteligente();
	public double consumo();
	public void intentarApagar();
	public void intentarEncender();
	public boolean estaEncendido();
	public void convertirAInteligente(Dispositivo dispositivo);
}
