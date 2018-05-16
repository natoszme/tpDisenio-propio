package repositorio;
import categoria.Categoria;

public class RepoCategorias extends Repo<Categoria> {
	
	private static RepoCategorias instancia;
	private static Categoria instanciaR1;
	
	public static RepoCategorias getInstance() {
		if (instancia == null) {
			instancia = new RepoCategorias();
		}
		return instancia;
	}
	
	private Categoria getR1Instance() {
		if (instanciaR1 == null) {
			instanciaR1 = new Categoria("R1", 0, 150, 18.76, 0.644); 
		}
		return instanciaR1; 
	}
	
	public Categoria obtenerCategoriaSegunConsumo(double consumo) {
		return entidades.stream().filter(categoria -> categoria.meCorrespondeElConsumo(consumo)).findFirst().orElse(this.getR1Instance());
	}

	public void limpiarEntidades() {
		entidades.clear();
	}
}