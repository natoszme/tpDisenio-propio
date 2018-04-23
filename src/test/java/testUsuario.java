import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUsuario {
	
	Categoria r1 = new CategoriaSinMinimo("r1", 0, 150, 18.76, 0.644);
	Categoria r2 = new Categoria("r2", 150, 325, 35.32, 0.644);
	Categoria r3 = new Categoria("r3", 325, 400, 60.71, 0.681);
	Categoria r4 = new Categoria("r4", 400, 450, 71.74, 0.738);
	Usuario nico = new Usuario("nico", "otamendi", TIPO_DOCUMENTO.DNI, 35102594, 42012594, "Av. Siempre Viva 20", r1, new ArrayList<Dispositivo>());
	Usuario pepe = new Usuario("pepe", "argento", TIPO_DOCUMENTO.CI, 12549785, 40000001, "Manuel Rodriguez 1251", r1, new ArrayList<Dispositivo>());
	Usuario lio = new Usuario("lio", "messi", TIPO_DOCUMENTO.DNI, 40216458, 10101010, "Av. Catalunia 10", r2, new ArrayList<Dispositivo>());
	Dispositivo tv = new Dispositivo("tv", 12, true, 10);
	Dispositivo aire = new Dispositivo("aire", 80, false, 2);
	Dispositivo homeTheater = new Dispositivo("home theater", 100, true, 1);
	
	@Before
	public void fixture() {
		RepoCategorias.getInstance().agregarCategoria(r1);
		RepoCategorias.getInstance().agregarCategoria(r2);
		RepoCategorias.getInstance().agregarCategoria(r3);
		RepoCategorias.getInstance().agregarCategoria(r4);
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
		Assert.assertEquals(r2, pepe.getCategoria());
	}
	
	@Test
	public void estaEnR2YAlConsumir380PasaAR3() {
		lio.recategorizar();
		Assert.assertEquals(r3, lio.categoria);
	}
}
