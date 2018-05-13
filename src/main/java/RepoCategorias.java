import java.util.ArrayList;
import java.util.List;

public class RepoCategorias extends Repo<Categoria>{
	private static RepoCategorias repoCategorias;
	
	public RepoCategorias() {
		ruta = "./data/categorias.json";
	}
	
	public static RepoCategorias getInstance(){
		if (repoCategorias == null) {
			repoCategorias = new RepoCategorias();
		}
		return repoCategorias;
	}
	
	public Categoria obtenerCategoriaSegunConsumo(double consumo) {
		Categoria r1 = new Categoria("r1", 0, 150, 18.76, 0.644);
		return entidades.stream().filter(categoria -> categoria.meCorrespondeElConsumo(consumo)).findFirst().orElse(r1);
	}
	
	public void cargarElementos() {
		CargarDataDesdeJSON<Categoria> cargadorData = new CargarDataDesdeJSON<>();
		agregarElementos(cargadorData.obtenerElementos(ruta, Categoria.class));
	}
}
