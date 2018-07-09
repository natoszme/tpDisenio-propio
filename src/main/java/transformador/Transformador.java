package transformador;

import java.util.List;

import cliente.Cliente;
import zona.ConsumoMasivoEnBaseA;
public class Transformador extends ConsumoMasivoEnBaseA<Cliente>{
	
	public Transformador() { /*es para el Json*/ }
	
	public Transformador(List<Cliente> clientes) {
		super(clientes);
	}

	public double miConsumoActual(Cliente cliente) {
		return cliente.consumoActual();
	}	
}
