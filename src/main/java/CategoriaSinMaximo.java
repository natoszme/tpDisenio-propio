
public class CategoriaSinMaximo extends Categoria {
	
	public CategoriaSinMaximo(String nombre, double consumoMinimo, double consumoMaximo, double cargoFijo, double cargoVariable) {
		super(nombre, consumoMinimo, consumoMaximo, cargoFijo, cargoVariable);
	}

	public boolean consumoCorrespondiente(double consumo) {
		return consumo > consumoMinimo;
	}
}