package importacion;

import categoria.Categoria;
import repositorio.RepoCategorias;

public class ImportadorCategorias extends Importador<Categoria>{
	
	private static ImportadorCategorias instancia;
	
	public static ImportadorCategorias getInstance() {
		if(instancia == null) {
			instancia = new ImportadorCategorias();
		}
		return instancia;
	}
	
	public void configurar() {
		rutaArchivo = "./resources/jsonData/categorias.json";
		repo = RepoCategorias.getInstance();
		entidad = Categoria.class;
	}
}
