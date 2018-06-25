package transformador;

import java.awt.Point;
import java.util.List;

import cliente.Cliente;
import repositorio.RepoTransformadores;

public class Transformador {
	private Point ubicacion;
	
	public Point ubicacion() {
		return ubicacion;
	}
	
	public double consumoActual() {
		return obtenerConsumoActualDe(RepoTransformadores.getInstance().obtenerClientesDe(this));
	}
	
	private double obtenerConsumoActualDe(List<Cliente> clientes) {
		return clientes.stream().mapToDouble(Cliente::dameConsumoActual).sum();
	}
	
	public double distanciaA(Cliente cliente) {
		return ubicacion.distance(cliente.getUbicacion());
	}
}
