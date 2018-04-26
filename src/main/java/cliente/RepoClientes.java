package cliente;
import java.util.ArrayList;
import java.util.List;

import categoria.RepoCategorias;
import json.JSONParser;
import json.ParserClientes;

public class RepoClientes {
	private static RepoClientes instancia;
	private List<Cliente> clientes = new ArrayList<>();
	
	public static RepoClientes getInstance(){
		if (instancia == null) {
			instancia = new RepoClientes();
		}
		return instancia;
	}
	
	public List<Cliente> obtenerTodos() {
		return clientes;
	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void agregarClientes(List<Cliente> clientes) {
		this.clientes.addAll(clientes);
	}
	
	public void cargarClientes() {
		JSONParser cargadorDeDatos = JSONParser.getInstance();
		RepoCategorias.getInstance().cargarCategorias();
		
		cargadorDeDatos.setTipoDato(new ParserClientes());
		cargadorDeDatos.parsear();
		this.clientes.forEach(Cliente::recategorizar);
	}
}