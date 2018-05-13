package repositorio;
import categoria.Categoria;

public class RepoCategorias extends Repo<Categoria> {
	
	private static RepoCategorias instancia;
	
	public static RepoCategorias getInstance(){
		if (instancia == null) {
			instancia = new RepoCategorias();
		}
		return instancia;
	}
	
	public Categoria obtenerCategoriaSegunConsumo(double consumo){
		Categoria r1 = new Categoria("R1", 0, 150, 18.76, 0.644);	
		return entidades.stream().filter(categoria -> categoria.meCorrespondeElConsumo(consumo)).findFirst().orElse(r1);
	}

	public void limpiarEntidades() {
		entidades.clear();		
	}
}