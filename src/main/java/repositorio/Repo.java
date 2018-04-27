package repositorio;

import java.util.ArrayList;
import java.util.List;

import json.JSONParser;

public abstract class Repo<Entidad> {
	protected List<Entidad> entidades = new ArrayList<>();
	protected String rutaArchivo;
	
	public List<Entidad> obtenerTodos() {
		return entidades;
	}

	public void agregarEntidad(Entidad entidad) {
		entidades.add(entidad);
	}
	
	public void setEntidades(List<Entidad> entidades) {
		this.entidades = entidades;		
	}

	public void agregarEntidades(List<Entidad> entidades) {
		this.entidades.addAll(entidades);
	}

	public List<Entidad> obtenerTodas() {
		return entidades;
	}
}
