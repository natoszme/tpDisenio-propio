package repositorio;

import transformador.Transformador;

public class RepoTransformadores extends Repo<Transformador>{
	
	private static RepoTransformadores instancia;
	
	public static RepoTransformadores getInstance() {
		if(instancia == null) {
			instancia = new RepoTransformadores();
		}
		return instancia;
	}
}
