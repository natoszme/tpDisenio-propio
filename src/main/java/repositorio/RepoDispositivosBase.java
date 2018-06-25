package repositorio;

import dispositivo.Dispositivo;

public class RepoDispositivosBase extends Repo<Dispositivo>{
	private static RepoDispositivosBase instancia;
	
	
	public static RepoDispositivosBase getInstance(){
		if (instancia == null) {
			instancia = new RepoDispositivosBase();
		}
		return instancia;
	}
	
	public Dispositivo dameDispositivo(String nombreDispositivo) {
		return entidades.stream().filter(dispositivo -> dispositivo.getNombre() == nombreDispositivo).
				findFirst().
				orElse(null);
	}
}
