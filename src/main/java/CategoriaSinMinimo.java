public class CategoriaSinMinimo extends Categoria{
	
	public CategoriaSinMinimo(String nombre,  double consumoMinimo, double consumoMaximo, double cargoFijo, double cargoVariable) {
		super(nombre, consumoMinimo, consumoMaximo, cargoFijo, cargoVariable);
	}

	public boolean consumoCorrespondiente(double consumo) {
		return consumo <= consumoMaximo;
	}

}
