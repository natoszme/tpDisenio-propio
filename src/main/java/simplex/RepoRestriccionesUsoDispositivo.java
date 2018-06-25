package simplex;

import java.util.ArrayList;
import java.util.List;

import dispositivo.Dispositivo;

public class RepoRestriccionesUsoDispositivo {
	
	private static RepoRestriccionesUsoDispositivo instancia;
	private List<RestriccionUsoDispositivo> restricciones = new ArrayList<>();
	
	
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
		RestriccionUsoDispositivo restriccion = restricciones.stream().filter(unaRestriccion -> unaRestriccion.esDe(dispositivo)).
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
