package repositorio;

import cliente.Cliente;

public class RepoClientes extends Repo<Cliente> {
	private static RepoClientes instancia;
	
	public static RepoClientes getInstance(){
		if (instancia == null) {
			instancia = new RepoClientes();
		}
		return instancia;
	}
}