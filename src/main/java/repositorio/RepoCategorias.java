package repositorio;
import categoria.Categoria;

public class RepoCategorias extends Repo<Categoria> {
	
	private static RepoCategorias instancia;
	
	public static RepoCategorias getInstance() {
		if (instancia == null) {
			instancia = new RepoCategorias();
		}
		return instancia;
	}
	
	public Categoria obtenerCategoriaSegunConsumo(double consumo) {
		return entidades.stream().filter(categoria -> categoria.meCorrespondeElConsumo(consumo)).findFirst().orElse(dameR1());
	}

	public void limpiarEntidades() {
		entidades.clear();
	}
	
	private Categoria dameR1() {
		return entidades.stream().filter(categoria -> categoria.getNombre() == "R1").findFirst().orElse(null);
	}
}