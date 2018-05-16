package dispositivo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import fabricante.Fabricante;
import fixture.Fixture;
import tipoDispositivo.DispositivoInteligente;

public class TestDispositivo extends Fixture {	

	// Test entrega 1
	
	@Test
	public void candelabroNoEsInteligente() {
		Assert.assertFalse(candelabro.esInteligente());
	}

	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Test
	public void smartTvEsInteligente() {
		televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockFabricante));
		Assert.assertTrue(televisorSmart.esInteligente());
	}	

	@Test
	public void consumoDeSmartTVEn1HoraSegunFabricanteQueRetorna20DeConsumoEs20() {
		Fabricante mockFabricanteRetorna20 = mock(Fabricante.class);
		when(mockFabricanteRetorna20.consumoDuranteLasUltimas(1,123456)).thenReturn(20.0);
		televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockFabricanteRetorna20));
		Assert.assertTrue(20.0== televisorSmart.consumoEnLasUltimas(1));
	}	
}
