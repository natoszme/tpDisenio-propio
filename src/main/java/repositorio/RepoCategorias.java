package repositorio;
import categoria.Categoria;

public class RepoCategorias extends Repo<Categoria> {
	
	private static RepoCategorias instancia;
	
	public RepoCategorias() {
		rutaArchivo = "./data/categorias";
	}
	
	public static RepoCategorias getInstance(){
		if (instancia == null) {
			instancia = new RepoCategorias();
		}
		return instancia;
	}
	
	public Categoria obtenerCategoriaSegunConsumo(double consumo){
		return entidades.stream().filter(categoria -> categoria.meCorrespondeElConsumo(consumo)).findFirst().orElse(null);
	}
}