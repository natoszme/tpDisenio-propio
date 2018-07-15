package consumoMasivo;

import java.util.List;

public abstract class ConsumoMasivoEnBaseA<TConsumidorMasivo extends ConsumidorMasivo> {
	
	public ConsumoMasivoEnBaseA() { /*es para el Json*/ }
	
	public double consumoActual(){
		return obtenerFuentesDeConsumo().stream().mapToDouble(ConsumidorMasivo::consumoActual).sum();
	}
	
	public abstract List<TConsumidorMasivo> obtenerFuentesDeConsumo();
}
