package importacion;

import java.util.List;

import cliente.Cliente;
import json.JSONParser;
import repositorio.RepoClientes;

public class ImportadorClientes {
	private static ImportadorClientes instancia;
	
	public static ImportadorClientes getInstance() {
		if(instancia == null) {
			return new ImportadorClientes();
		}
		return instancia;
	}
	
	String rutaArchivo = "./data/clientes.json";;
	public void importarJSON() {
		ImportadorCategorias.getInstance().importarJSON();
		JSONParser<Cliente> cargadorDeDatos = new JSONParser<Cliente>();
		List<Cliente> clientes = cargadorDeDatos.importar(rutaArchivo);
		clientes.forEach(Cliente::recategorizar);
		RepoClientes.getInstance().agregarEntidades(clientes);
	}
}
