package zona;

import org.junit.Assert;
import org.junit.Test;

import fixture.FixtureConsumoMasivo;
import repositorio.RepoClientes;
public class TestZona extends FixtureConsumoMasivo{
	
	@Test
	public void unTransformadorUbicadoEnElCorazonDePalermoLePerteneceADichaZona() {
		Assert.assertTrue(palermo.mePertenece(transformadorPalermo));
	}
	
	@Test
	public void unTransformadorUbicadoEnElCorazonDePalermoNoLePerteneceALaMatanza() {
		Assert.assertFalse(laMatanza.mePertenece(transformadorPalermo));
	}
	
	@Test
	public void aLaMatanzaNoLeCorrespondeElTransformadorDePalermo() {
		Assert.assertFalse(laMatanza.mePertenece(transformadorPalermo));
	}
	
	@Test
	public void aPalermoLeCorrespondeElConsumoDeTodosSusTransformadores() {
		Assert.assertEquals(50, palermo.consumoActual(), 0);
	}
	
	@Test
	public void aLaMatanzaLeCorrespondeElConsumoDeSusTransformadores() {
		Assert.assertEquals(180, laMatanza.consumoActual(), 0);
	}
	
	@Test 
	public void laZonaDeCaballitoTieneDosConsumidoresDeEnergia() {
		lio.agregarDispositivo(televisorSmart);
		RepoClientes.getInstance().agregarEntidad(lio);
		Assert.assertEquals(2, caballito.obtenerFuentesDeConsumo().size());
	}
	
	
}
