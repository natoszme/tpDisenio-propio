import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class RepoUsuarios {
	private static RepoUsuarios repoUsuarios;
	private static List<Usuario> usuarios = new ArrayList<>();
	
	public static RepoUsuarios getInstance(){
		if (repoUsuarios == null) {
			repoUsuarios = new RepoUsuarios();
		}
		return repoUsuarios;
	}

	public List<Usuario> obtenerTodos() {
		return usuarios;
	}

	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public void agregarUsuarios(List<Usuario> usuarios) {
		this.usuarios.addAll(usuarios);
	}
	
	public void cargarUsuarios() {
		CargarDataDesdeJSON cargadorDeDatos = new CargarDataDesdeJSON().getInstance();
		RepoCategorias.getInstance().cargarCategorias();
		
		cargadorDeDatos.setTipoDato(new CargarUsuarios());
		
		//estaria bueno que esto devuelva a los usuarios, pero tendriamos quilombo con los tipos que devuelve cargadorDeDatos
		//habria que agregar una superclase que englobe a las 2 y se complejizaria mucho
		//esto esta mal?
		cargadorDeDatos.cargar("usuarios");
		
		this.usuarios.forEach(Usuario::recategorizar);
	}
}