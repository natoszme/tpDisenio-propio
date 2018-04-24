import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUsuario extends FixtureGlobal{
	
	@Before
	public void fixture() {
		RepoCategorias.getInstance().agregarCategorias(new ArrayList<>(Arrays.asList(r1, r2, r3, r4)));
		pepe.agregarDispositivo(tv);
		pepe.agregarDispositivo(aire);
		
		lio.agregarDispositivo(tv);
		lio.agregarDispositivo(aire);
		lio.agregarDispositivo(homeTheater);
	}
		
	@Test
	public void alguienSinDispositivosTiene0EnTotal() {
		Assert.assertEquals(0, nico.cantidadDispositivos());
	}
	
	@Test
	public void alguienSinDispositivosTiene0Encendidos() {
		Assert.assertEquals(0, nico.cantidadEncendidos());
	}
	
	@Test
	public void alguienSinDispositivosTiene0Apagados() {
		Assert.assertEquals(0, nico.cantidadApagados());
	}
	
	@Test
	public void alguienSinDispositivosNoTieneEncendidos() {
		Assert.assertFalse(nico.algunDispositivoEncendido());
	}
	
	/*@Test
	public void pepeTiene2DispositivosYAlConsultarSuEstadoSeLesEnviaUnMensaje() {
		//Mock dispositivo = new Mo
		Dispositivo tv = new Mock(Dispositivo.class);
		
		verify(tv, times(2)).estaEncendido();
	}*/
	
	@Test
	public void hastaElMomentoNicoConsumio0() {
		Assert.assertEquals(0, nico.consumoHastaElMomento(), 0);
	}
	
	@Test
	public void hastaElMomentoPepeConsumio280() {
		Assert.assertEquals(280, pepe.consumoHastaElMomento(), 0);
	}
	
	@Test
	public void hastaElMomentoLioConsumio380() {
		Assert.assertEquals(380, lio.consumoHastaElMomento(), 0);
	}
	
	//se puede evitar crear dispositivos para testear? o en este caso es inevitable,
	//ya que la recategorizacion depende de cuánto consuman?
	@Test
	public void estaEnR1YAlConsumir120NoSeRecategoriza() {
		pepe.recategorizar();
		Assert.assertEquals(r2.getNombre(), pepe.getCategoria().getNombre());
	}
	
	@Test
	public void estaEnR2YAlConsumir380PasaAR3() {
		lio.recategorizar();
		Assert.assertEquals(r3.getNombre(), lio.categoria.getNombre());
	}
}
