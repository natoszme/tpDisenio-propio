
public class CategoriaSinMaximo extends Categoria {
	
	public CategoriaSinMaximo(String nombre, double consumoMinimo, double cargoFijo, double cargoVariable) {
		super(nombre, consumoMinimo, 0, cargoFijo, cargoVariable);
	}

	public boolean meCorrespondeElConsumo(double consumo) {
		return consumo > consumoMinimo;
	}
}