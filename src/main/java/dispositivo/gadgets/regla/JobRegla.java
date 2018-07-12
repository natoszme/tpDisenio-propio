package dispositivo.gadgets.regla;

import repositorio.RepoReglas;

public class JobRegla {
	
	public static JobRegla instancia;
	public static JobRegla getInstance() {
		if (instancia == null) {
			instancia = new JobRegla();
		}
		return instancia;
	}
	
	public void ejecutar() {
		RepoReglas.getInstance().obtenerTodas().forEach(regla -> regla.aplicarSiCumpleCriterio());
	}	
}