import com.fasterxml.jackson.annotation.JsonRootName;

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
	
	//como evitar pasale un null al constructor de las subclases?
	/*public Categoria(String nombre, double consumoMinimo, double cargoFijo, double cargoVariable) {
		this.nombre = nombre;
		this.consumoMinimo = consumoMinimo;
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
	}*/
	
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
		return estaEntre(consumo, consumoMinimo, consumoMaximo);
	}
	
	private boolean estaEntre(double consumo, double consumoMinimo, double consumoMaximo) {
		return consumo <= consumoMaximo && consumo > consumoMinimo;
	}
}
