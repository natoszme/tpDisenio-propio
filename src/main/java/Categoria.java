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
	
	public String getNombre() {
		return this.nombre;
	}
	
	public boolean meCorrespondeElConsumo(double consumo) {
		return consumo <= consumoMaximo && consumo > consumoMinimo;
	}
}
