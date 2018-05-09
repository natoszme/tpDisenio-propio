package importacion;

import json.JSONParser;
import repositorio.Repo;

abstract public class Importador<Entidad> {
	protected String rutaArchivo;
	Repo<Entidad> repo;
	protected Class<Entidad> entidad;
	public void importarJSON() {
		configurar();
		JSONParser<Entidad> cargadorDeDatos = new JSONParser<Entidad>();
		repo.agregarEntidades(cargadorDeDatos.importar(rutaArchivo, entidad));
	}
	
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;		
	}
	
	abstract public void configurar();
}
