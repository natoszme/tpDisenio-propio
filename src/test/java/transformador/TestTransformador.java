package transformador;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fixture.Fixture;
import repositorio.RepoClientes;
import repositorio.RepoTransformadores;

public class TestTransformador extends Fixture{
	
	@Before
	public void before() {
		//TODO por que sin estas dos rompe?
		RepoTransformadores.getInstance().limpiarEntidades();
		RepoClientes.getInstance().limpiarEntidades();
		
		RepoTransformadores.getInstance().agregarEntidad(transformadorLaMatanza);
		RepoTransformadores.getInstance().agregarEntidad(transformadorPalermo);
		
		when(mockAireConcreto.consumoActual()).thenReturn(180.0);
		alejandro.agregarDispositivo(aireAcondicionado);
		RepoClientes.getInstance().agregarEntidad(alejandro);
		
		when(mockTelevisorSmartConcreto.consumoActual()).thenReturn(50.0);
		nico.agregarDispositivo(televisorSmart);
		RepoClientes.getInstance().agregarEntidad(nico);
	}
	
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
