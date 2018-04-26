package categoria;
public class Categoria {
	String nombre;
	double consumoMinimo;
	double consumoMaximo;
	double cargoFijo;
	double cargoVariable;
	
	public Categoria() { /*es para el Json*/ }
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
	
	public double getConsumoMinimo() {
		return this.consumoMinimo;
	}
	
	public double getConsumoMaximo() {
		return this.consumoMaximo;
	}
	
	public double getCargoFijo() {
		return this.cargoFijo;
	}
	
	public double getCargoVariable() {
		return this.cargoVariable;
	}
	
	public boolean meCorrespondeElConsumo(double consumo) {
		return consumoAcordeAMaximo(consumo) && consumoAcordeAMinimo(consumo);
	}
	
	public boolean consumoAcordeAMaximo(double consumo) {
		return consumo <= consumoMaximo;
	}
	
	public boolean consumoAcordeAMinimo(double consumo) {
		return consumo > consumoMinimo;
	}
}
