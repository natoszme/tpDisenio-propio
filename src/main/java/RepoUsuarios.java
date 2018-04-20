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
}