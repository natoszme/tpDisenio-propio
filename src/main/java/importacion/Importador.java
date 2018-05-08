package importacion;

import categoria.Categoria;
import json.JSONParser;
import repositorio.Repo;
import repositorio.RepoCategorias;

public class Importador<Entidad> {
	protected String rutaArchivo;
	public void importarJSON() {
		JSONParser<Entidad> cargadorDeDatos = new JSONParser<Entidad>();
		/*aca va el repo segun Entidad*/.getInstance().agregarEntidades(cargadorDeDatos.importar(rutaArchivo, Entidad));
	}
	
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;		
	}
}
