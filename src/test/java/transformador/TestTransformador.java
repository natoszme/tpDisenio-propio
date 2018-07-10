package transformador;

import org.junit.Assert;
import org.junit.Test;

import fixture.FixtureConsumoMasivo;
import repositorio.RepoClientes;

public class TestTransformador extends FixtureConsumoMasivo{
	
	@Test
	public void elConsumoActualDeLaMatanzaEsElDeSuUnicoCliente() {		
		Assert.assertEquals(180, transformadorLaMatanza.consumoActual(), 0);
	}
	
	@Test
	public void elConsumoDePalermoEsElDeNicoSolamente() {
		Assert.assertEquals(50, transformadorPalermo.consumoActual(), 0);
	}
	
	@Test
	public void elConsumoDePalermoConUnNuevoClienteEsElDeAmbos() {
		ricardo.agregarDispositivo(televisorSmart);
		RepoClientes.getInstance().agregarEntidad(ricardo);
		Assert.assertEquals(100, transformadorPalermo.consumoActual(), 0);
	}
}
