package zona;

import java.util.List;

public abstract class ConsumoMasivoEnBaseA<ConsumidorMasivo> {
	
	public ConsumoMasivoEnBaseA() { /*es para el Json*/ }
	
	//TODO se puede evitar mandar el mensaje a la subclase?
	public double consumoActual(){
		return obtenerFuentesDeConsumo().stream().mapToDouble(consumidorMasivo -> miConsumoActual(consumidorMasivo)).sum();
	}
	
	public abstract List<ConsumidorMasivo> obtenerFuentesDeConsumo();

	public abstract double miConsumoActual(ConsumidorMasivo consumidorMasivo);
}
