package zona;

import java.util.List;

import transformador.Transformador;

public class Zona extends ConsumoMasivoEnBaseA<Transformador>{
	
	private String nombre;
	
	public Zona(String nombre, List<Transformador> transformadores) {
		super(transformadores);
		this.nombre = nombre;
	}

	public double miConsumoActual(Transformador transformador) {
		return transformador.consumoActual();
	}
}
