package importacion;

import categoria.Categoria;
import json.JSONParser;
import repositorio.RepoCategorias;

public class ImportadorCategorias {
	
	private static ImportadorCategorias instancia;
	
	public static ImportadorCategorias getInstance() {
		if(instancia == null) {
			return new ImportadorCategorias();
		}
		return instancia;
	}
	
	String rutaArchivo = "./data/categorias.json";;
	public void importarJSON() {
		JSONParser<Categoria> cargadorDeDatos = new JSONParser<Categoria>();
		RepoCategorias.getInstance().agregarEntidades(cargadorDeDatos.importar(rutaArchivo));
	}
}
