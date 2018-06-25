package importacion;

import repositorio.RepoTransformadores;
import transformador.Transformador;

public class ImportadorTransformadores extends Importador<Transformador>{
	
	private static ImportadorTransformadores instancia;
	
	public static ImportadorTransformadores getInstance() {
		if (instancia == null) {
			instancia = new ImportadorTransformadores("./resources/jsonData/transformadores.json", RepoTransformadores.getInstance(), Transformador.class);
		}
		return instancia;
	}
	
	private ImportadorTransformadores(String rutaArchivo, RepoTransformadores repo, Class<Transformador> entidad) {
		super(rutaArchivo, repo, entidad);
	}
}
