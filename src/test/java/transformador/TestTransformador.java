package transformador;

import org.junit.Assert;
import org.junit.Test;

import fixture.FixtureConsumoMasivo;
import repositorio.RepoClientes;
import repositorio.RepoTransformadores;

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
	
	@Test
	public void elTransformadorDeCaballitoTieneAYaninayLioDeClientes() {
		RepoClientes.getInstance().agregarEntidad(lio);
		Assert.assertEquals(2, RepoTransformadores.getInstance().obtenerClientesDe(transformadorCaballito).size(), 0);
	}
	
	@Test 
	public void alAgregarUnNuevoDispositivoAumentaLaEnergiaSumistridadPorElTransformador() {
		RepoClientes.getInstance().agregarEntidad(lio);
		double consumoAnterior = transformadorCaballito.consumoActual();
		yanina.agregarDispositivo(televisorSmart);
		Assert.assertTrue(consumoAnterior < transformadorCaballito.consumoActual());
	}
		
}
