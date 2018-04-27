import java.util.ArrayList;
import java.util.List;

public class RepoUsuarios extends Repo<Usuario>{
	private static RepoUsuarios instancia;
	List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public RepoUsuarios() {
		ruta = "./data/usuarios.json";
	}
	
	public static RepoUsuarios getInstance(){
		if (instancia == null) {
			instancia = new RepoUsuarios();
		}
		return instancia;
	}
	
	public void cargarElementos() {
		RepoCategorias.getInstance().cargarElementos();
		
		CargarDataDesdeJSON<Usuario> cargadorData = new CargarDataDesdeJSON<>();
		List<Usuario> usuarios = cargadorData.obtenerElementos(ruta, Usuario.class);
		usuarios.forEach(Usuario::recategorizar);
		agregarElementos(usuarios);
	}
}