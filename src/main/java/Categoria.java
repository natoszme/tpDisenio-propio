
public class Categoria {
	String nombre;
	double consumoMinimo;
	double consumoMaximo;
	double cargoFijo;
	double cargoVariable;
	
	public Categoria(String nombre, double consumoMinimo, double consumoMaximo, double cargoFijo, double cargoVariable) {
		this.nombre = nombre;
		this.consumoMinimo = consumoMinimo;
		this.consumoMaximo = consumoMaximo;
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
	}
	
	//necesario para leer un JSON
	public Categoria() {}
	
	public String getNombre() {
		return nombre;
	}

	public double getConsumoMinimo() {
		return consumoMinimo;
	}

	public double getConsumoMaximo() {
		return consumoMaximo;
	}

	public double getCargoFijo() {
		return cargoFijo;
	}

	public double getCargoVariable() {
		return cargoVariable;
	}

	public boolean meCorrespondeElConsumo(double consumo) {
		return consumo <= consumoMaximo && consumo > consumoMinimo;
	}
}
