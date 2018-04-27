import java.util.ArrayList;
import java.util.List;

public abstract class Repo<Entidad> {
	
	Entidad entidad;
	private List<Entidad> entidades = new ArrayList<>();
	String ruta;

	public List<Entidad> obtenerTodos() {
		return entidades;
	}

	public void agregarElemento(Entidad entidad) {
		entidades.add(entidad);
	}

	public void agregarElementos(List<Entidad> entidad) {
		this.entidades.addAll(entidad);
	}
}
