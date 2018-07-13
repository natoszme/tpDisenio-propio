package repositorio;
import java.util.List;
import java.util.stream.Collectors;

import dispositivo.gadgets.regla.Regla;

public class RepoReglas extends Repo<Regla>{
	
	private static RepoReglas instancia;
	
	public static RepoReglas getInstance() {
		if(instancia == null) {
			instancia = new RepoReglas();
		}
		return instancia;
	}
	
	// TODO revisar y discutir todo lo de abajo!!!

	@Override
	public void agregarEntidad(Regla regla) {
		reemplazarSiExiste(regla);
	}

	@Override
	public void agregarEntidades(List<Regla> reglas) {
		reglas.forEach(regla -> agregarEntidad(regla));
	}
	
	private void reemplazarSiExiste(Regla nuevaRegla) {
		entidades = entidades.stream().filter(reglaExistente -> !reglaExistente.esIgualA(nuevaRegla)).collect(Collectors.toList());
		entidades.add(nuevaRegla);
	}
}