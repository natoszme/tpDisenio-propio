public class CategoriaSinMinimo extends Categoria{
	
	public CategoriaSinMinimo(String nombre, double consumoMaximo, double cargoFijo, double cargoVariable) {
		super(nombre, 0, consumoMaximo, cargoFijo, cargoVariable);
	}

	public boolean meCorrespondeElConsumo(double consumo) {
		return super.consumoAcordeAMaximo(consumo);
	}

}
