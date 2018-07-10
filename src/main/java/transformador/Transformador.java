package transformador;

import java.util.List;

import org.uqbar.geodds.Point;

import cliente.Cliente;
import repositorio.RepoTransformadores;
import zona.ConsumoMasivoEnBaseA;
public class Transformador extends ConsumoMasivoEnBaseA<Cliente>{
	
	private Point ubicacion;
	
	public Transformador() { /*es para el Json*/ }

	public Transformador(Point ubicacion) {
		this.ubicacion = ubicacion;
	}

	public double miConsumoActual(Cliente cliente) {
		return cliente.consumoActual();
	}

	public Point ubicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(Point ubicacion) {
		this.ubicacion = ubicacion;
	}
		
	public double distanciaA(Cliente cliente) {	
		return ubicacion.distance(cliente.ubicacion());	
 	}

	public List<Cliente> obtenerFuentesDeConsumo() {
		return RepoTransformadores.getInstance().obtenerClientesDe(this);
	}
}
