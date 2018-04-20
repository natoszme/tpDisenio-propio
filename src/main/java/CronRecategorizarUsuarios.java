
public class CronRecategorizarUsuarios {
	
	void ejecutar() {
		RepoUsuarios.getInstance().obtenerTodos().stream().forEach(usuario->usuario.recategorizar());
	}
}
