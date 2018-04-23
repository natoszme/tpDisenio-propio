import java.util.ArrayList;
import java.util.List;

//import com.fasterxml.jackson.databind.JsonNode;

public class RepoClientes {
	private static RepoClientes repoClientes;
	private static List<Cliente> clientes = new ArrayList<>();
	
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
}