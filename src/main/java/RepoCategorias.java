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
		return categorias.stream().filter(categoria -> categoria.consumoCorrespondiente(consumo)).findFirst().orElse(null);
	}
	
	public void agregarCategoria(Categoria categoria) {
		categorias.add(categoria);		
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;		
	}
}