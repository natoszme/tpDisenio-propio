package repositorio;

import cliente.Cliente;

public class RepoClientes extends Repo<Cliente> {
	private static RepoClientes instancia;
	
	public RepoClientes() {
		rutaArchivo = "./data/clientes";
	}
	
	public static RepoClientes getInstance(){
		if (instancia == null) {
			instancia = new RepoClientes();
		}
		return instancia;
	}
	
	public void importarJSON() {
		RepoCategorias.getInstance().importarJSON();		
		super.importarJSON();
		this.entidades.forEach(Cliente::recategorizar);
	}
}