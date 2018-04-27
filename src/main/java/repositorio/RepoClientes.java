package repositorio;

import cliente.Cliente;
import json.JSONParser;

public class RepoClientes extends Repo<Cliente> {
	private static RepoClientes instancia;
	
	public RepoClientes() {
		rutaArchivo = "./data/clientes.json";
	}
	
	public static RepoClientes getInstance(){
		if (instancia == null) {
			instancia = new RepoClientes();
		}
		return instancia;
	}
	
	public void importarJSON() {
		RepoCategorias.getInstance().importarJSON();		
		JSONParser<Cliente> cargadorDeDatos = new JSONParser<Cliente>();
		agregarEntidades(cargadorDeDatos.importar(this.rutaArchivo, Cliente.class));
		entidades.forEach(Cliente::recategorizar);
	}
}