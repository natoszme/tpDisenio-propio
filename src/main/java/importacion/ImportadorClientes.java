package importacion;

import cliente.Cliente;
import repositorio.RepoClientes;

public class ImportadorClientes extends Importador<Cliente>{
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
		super.importarJSON();
		RepoClientes.getInstance().obtenerTodas().forEach(Cliente::recategorizar);;
	}
}
