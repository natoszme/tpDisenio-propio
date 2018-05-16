package dispositivo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import fabricante.Fabricante;
import fixture.Fixture;
import tipoDispositivo.DispositivoInteligente;

public class TestDispositivo extends Fixture {	
	@Test
	public void candelabroNoEsInteligente() {
		Assert.assertFalse(candelabro.esInteligente());
	}
	
	//TODO intentar pasar esto al fixture, habia un error con las annotations
	@Mock
	Fabricante mockFabricante; 
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Test
	public void smartTvEsInteligente() {
		televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockFabricante));
		Assert.assertTrue(televisorSmart.esInteligente());
	}
	
}
