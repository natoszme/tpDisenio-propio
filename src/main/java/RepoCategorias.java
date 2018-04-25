import java.util.ArrayList;
import java.util.List;

public class RepoCategorias {
	
	private static RepoCategorias repoCategorias;
	private List<Categoria> categorias = new ArrayList<>();
	
	public static RepoCategorias getInstance(){
		if (repoCategorias == null) {
			repoCategorias = new RepoCategorias();
		}
		return repoCategorias;
	}
	
	public Categoria obtenerCategoriaSegunConsumo(double consumo){
		return categorias.stream().filter(categoria -> categoria.meCorrespondeElConsumo(consumo)).findFirst().orElse(null);
	}
	
	public void agregarCategoria(Categoria categoria) {
		categorias.add(categoria);		
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;		
	}

	public void agregarCategorias(List<Categoria> categorias) {
		this.categorias.addAll(categorias);
	}

	public static void cargarCategorias() {
		JSONParser parserDeDatos = JSONParser.getInstance();
		parserDeDatos.setTipoDato(new ParserCategorias());
		parserDeDatos.parsear();
	}

	public List<Categoria> obtenerTodas() {
		return categorias;
	}
}