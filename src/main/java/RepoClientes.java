import java.util.ArrayList;
import java.util.List;

public class RepoClientes {
	private static RepoClientes repoClientes;
	private List<Cliente> clientes = new ArrayList<>();
	
	public static RepoClientes getInstance(){
		if (repoClientes == null) {
			repoClientes = new RepoClientes();
		}
		return repoClientes;
	}
	
	public List<Cliente> obtenerTodos() {
		return clientes;
	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void agregarClientes(List<Cliente> clientes) {
		this.clientes.addAll(clientes);
	}
	
	public void cargarClientes() {
		JSONParser cargadorDeDatos = JSONParser.getInstance();
		RepoCategorias.getInstance().cargarCategorias();
		
		cargadorDeDatos.setTipoDato(new ParserClientes());
		cargadorDeDatos.parsear("usuarios");
		this.clientes.forEach(Cliente::recategorizar);
	}
}