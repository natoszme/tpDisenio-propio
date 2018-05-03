package repositorio;

import java.util.ArrayList;
import java.util.List;

import categoria.Categoria;
import json.JSONParser;

public abstract class Repo<Entidad> {
	protected List<Entidad> entidades = new ArrayList<>();
	
	public List<Entidad> obtenerTodos() {
		return entidades;
	}

	public void agregarEntidad(Entidad entidad) {
		entidades.add(entidad);
	}

	public void agregarEntidades(List<Entidad> entidades) {
		this.entidades.addAll(entidades);
	}

	public List<Entidad> obtenerTodas() {
		return entidades;
	}
}
