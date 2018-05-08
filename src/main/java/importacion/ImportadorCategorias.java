package importacion;

import categoria.Categoria;

public class ImportadorCategorias extends Importador<Categoria>{
	
	private static ImportadorCategorias instancia;
	
	public static ImportadorCategorias getInstance() {
		if(instancia == null) {
			return new ImportadorCategorias();
		}
		return instancia;
	}
}
