package zona;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import transformador.Transformador;

public class Zona {
	private Point ubicacion;
	private double radio;
	private  List<Transformador> transformadores = new ArrayList<>();
	
	public double consumoActual(){
		return transformadores.stream().mapToDouble(Transformador::consumoActual).sum();
	}
}
