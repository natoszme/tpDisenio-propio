package importacion;

import cliente.Cliente;

import repositorio.RepoClientes;

public class ImportadorClientes extends Importador<Cliente>{
	private static ImportadorClientes instancia;
	
	public static ImportadorClientes getInstance() {
		if(instancia == null) {
			instancia = new ImportadorClientes("./resources/jsonData/clientes.json", RepoClientes.getInstance(), Cliente.class);
		}
		return instancia;
	}
	
	public void importarJSON() {
		ImportadorCategorias.getInstance().importarJSON();
		super.importarJSON();
		repo.obtenerTodas().forEach(Cliente::recategorizar);
	}
	
	private ImportadorClientes(String rutaArchivo, RepoClientes repo, Class<Cliente> entidad) {
		super(rutaArchivo, repo, entidad);
	}
	 
}
