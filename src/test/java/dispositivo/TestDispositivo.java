package dispositivo;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import fabricante.Fabricante;
import fixture.Fixture;
import tipoDispositivo.DispositivoInteligente;
import tipoDispositivo.ElMensajeEnviadoNoPuedeSerRespondidoPorUnEstandar;
import tipoDispositivo.NoSePuedeReConvertirAInteligenteException;

public class TestDispositivo extends Fixture {
	
	@Test
	public void candelabroEsInteligenteDespuesDeConvertirseAInteligente() {
		candelabro.convertirAInteligente(123, mockFabricante);
		Assert.assertTrue(candelabro.esInteligente());
	}
	
	@Test
	public void elConsumoDelCandelabroEn1HoraEs9() {
		Assert.assertEquals(9.0, candelabro.consumoEnLasUltimas(1), 0);
	}
	
	@Test
	public void candelabroNoEsInteligente() {
		Assert.assertFalse(candelabro.esInteligente());
	}

	@Test(expected = ElMensajeEnviadoNoPuedeSerRespondidoPorUnEstandar.class)
	public void candelabroNoPuedeEstarEnAModoAhorro() {
		candelabro.estaEnAhorroEnergia();
	}
	
	@Test
	public void alApagarSmartTVFabricanteRecibeMensajeApagar() {
		televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockFabricante));
		televisorSmart.apagar();	
		verify(mockFabricante,times(1)).apagar(123456);
	}	
	
	@Test
	public void smartTvEsInteligente() {
		televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockFabricante));
		Assert.assertTrue(televisorSmart.esInteligente());
	}	
	
	@Test(expected = NoSePuedeReConvertirAInteligenteException.class)
	public void smartTvNoSePuedeConvertirAInteligente() {
		televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockFabricante));
		televisorSmart.convertirAInteligente(123, mockFabricante);
	}	

	@Test
	public void consumoDeSmartTVEn1HoraSegunFabricanteQueRetorna20DeConsumoEs20() {
		Fabricante mockFabricanteRetorna20 = mock(Fabricante.class);
		when(mockFabricanteRetorna20.consumoDuranteLasUltimas(1, 123456)).thenReturn(20.0);
		televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockFabricanteRetorna20));
		Assert.assertEquals(20.0, televisorSmart.consumoEnLasUltimas(1), 0);
	}
	
	@Test
	public void plazoMayorAlDelCronDevuelveBienElConsumoGuardado() {
		DispositivoInteligente smartTvAdapter = new DispositivoInteligente(123456, null);
		televisorSmart = new Dispositivo("Televisor Smart", smartTvAdapter);
		televisorSmart.guardarConsumoDeFecha(LocalDateTime.now().minusHours(6), 30);
		Assert.assertEquals(30, smartTvAdapter.consumoAlmacenadoEn(12), 0);
	}
	
	@Test
	public void elConsumoDesdeLasUltimas12HorasEsMayorAlDadoPorElFabricante() {
		Fabricante mockFabricanteRetorna20 = mock(Fabricante.class);
		when(mockFabricanteRetorna20.consumoDuranteLasUltimas(6, 123456)).thenReturn(20.0);
		televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockFabricanteRetorna20));
		televisorSmart.guardarConsumoDeFecha(LocalDateTime.now().minusHours(6), 30);
		Assert.assertEquals(50.0, televisorSmart.consumoEnLasUltimas(12), 0);
	}
}
