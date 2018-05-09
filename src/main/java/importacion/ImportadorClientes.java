package importacion;

import cliente.Cliente;
import repositorio.RepoClientes;

public class ImportadorClientes extends Importador<Cliente>{
	private static ImportadorClientes instancia;
	
	public static ImportadorClientes getInstance() {
		if(instancia == null) {
			instancia = new ImportadorClientes();
		}
		return instancia;
	}
	
	public void importarJSON() {
		ImportadorCategorias.getInstance().importarJSON();
		super.importarJSON();
		repo.obtenerTodas().forEach(Cliente::recategorizar);;
	}
	
	public void configurar() {
		rutaArchivo = "./resources/jsonData/clientes.json";
		repo = RepoClientes.getInstance();
		entidad = Cliente.class;
	}
	 
}
