package repositorio;
import categoria.Categoria;
import json.JSONParser;

public class RepoCategorias extends Repo<Categoria> {
	
	private static RepoCategorias instancia;
	
	public RepoCategorias() {
		rutaArchivo = "./data/categorias.json";
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
	
	public void importarJSON() {
		JSONParser<Categoria> cargadorDeDatos = new JSONParser<Categoria>();
		agregarEntidades(cargadorDeDatos.importar(this.rutaArchivo, Categoria.class));
	}
}