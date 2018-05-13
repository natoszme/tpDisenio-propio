import java.util.ArrayList;
import java.util.List;

public abstract class Repo<Entidad> {
	
	Entidad entidad;
	protected List<Entidad> entidades = new ArrayList<>();
	protected String ruta;

	public List<Entidad> obtenerTodos() {
		return entidades;
	}

	public void agregarElemento(Entidad entidad) {
		entidades.add(entidad);
	}

	public void agregarElementos(List<Entidad> entidades) {
		this.entidades.addAll(entidades);
	}
}
