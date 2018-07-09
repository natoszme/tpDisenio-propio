package zona;

import java.util.ArrayList;
import java.util.List;

public abstract class ConsumoMasivoEnBaseA<ConsumidorMasivo> {

	private  List<ConsumidorMasivo> consumidoresMasivos = new ArrayList<>();
	
	public ConsumoMasivoEnBaseA() { /*es para el Json*/ }
	
	public ConsumoMasivoEnBaseA(List<ConsumidorMasivo> consumidoresMasivos){
		this.consumidoresMasivos = consumidoresMasivos;
	}
	
	//TODO se puede evitar mandar el mensaje a la subclase?
	public double consumoActual(){
		return consumidoresMasivos.stream().mapToDouble(consumidorMasivo -> miConsumoActual(consumidorMasivo)).sum();
	}
	
	public abstract double miConsumoActual(ConsumidorMasivo consumidorMasivo);
}
