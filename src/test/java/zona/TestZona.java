package zona;

import org.junit.Assert;
import org.junit.Test;

import fixture.Fixture;

public class TestZona extends Fixture{
	
	@Test
	public void unTransformadorUbicadoEnElCorazonDePalermoLePerteneceADichaZona() {
		Assert.assertTrue(palermo.mePertenece(transformadorPalermo));
	}
	
	@Test
	public void unTransformadorUbicadoEnElCorazonDePalermoNoLePerteneceALaMatanza() {
		Assert.assertFalse(laMatanza.mePertenece(transformadorPalermo));
	}
	
	@Test
	public void aPalermoLeCorrespondeElConsumoDeTodosSusTransformadores() {
		
	}
}
