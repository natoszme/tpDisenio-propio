package categoria;
import java.util.ArrayList;
import java.util.List;

import json.JSONParser;
import json.ParserCategorias;

public class RepoCategorias {
	
	private static RepoCategorias instancia;
	private List<Categoria> categorias = new ArrayList<>();
	
	public static RepoCategorias getInstance(){
		if (instancia == null) {
			instancia = new RepoCategorias();
		}
		return instancia;
	}
	
	public Categoria obtenerCategoriaSegunConsumo(double consumo){
		return categorias.stream().filter(categoria -> categoria.meCorrespondeElConsumo(consumo)).findFirst().orElse(null);
	}
	
	public void agregarCategoria(Categoria categoria) {
		categorias.add(categoria);		
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;		
	}

	public void agregarCategorias(List<Categoria> categorias) {
		this.categorias.addAll(categorias);
	}

	public void cargarCategorias() {
		JSONParser parserDeDatos = JSONParser.getInstance();
		parserDeDatos.setTipoDato(new ParserCategorias());
		parserDeDatos.parsear();
	}

	public List<Categoria> obtenerTodas() {
		return categorias;
	}
}