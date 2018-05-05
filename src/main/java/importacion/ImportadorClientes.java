package importacion;

import java.util.List;

import cliente.Cliente;
import json.JSONParser;
import repositorio.RepoClientes;

public class ImportadorClientes {
	private static ImportadorClientes instancia;
	private static String rutaArchivo = "./data/clientes.json";
	
	public static ImportadorClientes getInstance() {
		if(instancia == null) {
			return new ImportadorClientes();
		}
		return instancia;
	}
	
	public void importarJSON() {
		ImportadorCategorias.getInstance().importarJSON();
		JSONParser<Cliente> cargadorDeDatos = new JSONParser<Cliente>();
		List<Cliente> clientes = cargadorDeDatos.importar(rutaArchivo, Cliente.class);
		clientes.forEach(Cliente::recategorizar);
		RepoClientes.getInstance().agregarEntidades(clientes);
	}
	
	public void setRutaArchivo(String rutaArchivo) {
		ImportadorClientes.rutaArchivo = rutaArchivo;
	}
}
