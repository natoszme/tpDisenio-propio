package simplex;
import dispositivo.Dispositivo;
import repositorio.Repo;

public class RepoRestriccionesUsoDispositivo extends Repo<RestriccionUsoDispositivo> {
	
	private static RepoRestriccionesUsoDispositivo instancia;	
	
	public static RepoRestriccionesUsoDispositivo getInstance(){
		if (instancia == null) {
			instancia = new RepoRestriccionesUsoDispositivo();
		}
		return instancia;
	}
	
	/*public RestriccionUsoDispositivo dameRestriccionesDe(Dispositivo dispositivo) {
		return restricciones.stream().filter(restriccion -> restriccion.esDe(dispositivo)).
				findFirst().orElse(null);
	}*/
	
	private RestriccionUsoDispositivo obtenerRestriccionDe(Dispositivo dispositivo) {
		RestriccionUsoDispositivo restriccion = entidades.stream().filter(unaRestriccion -> unaRestriccion.esDe(dispositivo)).
				findFirst().orElseThrow(() -> new NoExisteRestriccionPara(dispositivo));
		return restriccion;
	}
	
	public double dameRestriccionMaximaDe(Dispositivo dispositivo) {
		RestriccionUsoDispositivo restriccion = obtenerRestriccionDe(dispositivo);
		
		return restriccion.getUsoMensualMaximo();
	}
	
	public double dameRestriccionMinimaDe(Dispositivo dispositivo) {
		RestriccionUsoDispositivo restriccion = obtenerRestriccionDe(dispositivo);
		
		return restriccion.getUsoMensualMinimo();
	}
}
