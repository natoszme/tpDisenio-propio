import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUsuario {
	
	Categoria r1 = new Categoria("r1", 0, 150, 18.76, 0.644);
	Categoria r2 = new Categoria("r2", 150, 325, 35.32, 0.644);
	Usuario nico = new Usuario("nico", "otamendi", TIPO_DOCUMENTO.DNI, 35102594, 42012594, "Av. Siempre Viva 20", r1, new ArrayList<Dispositivo>());
	Usuario pepe = new Usuario("pepe", "argento", TIPO_DOCUMENTO.CI, 12549785, 40000001, "Manuel Rodriguez 1251", r1, new ArrayList<Dispositivo>());
	Dispositivo tv = new Dispositivo("tv", 12, true, 10);
	Dispositivo aire = new Dispositivo("aire", 80, false, 2);
	
	@Before
	public void fixture() {
		RepoCategorias.getInstance().agregarCategoria(r1);
		RepoCategorias.getInstance().agregarCategoria(r2);
		pepe.agregarDispositivo(tv);
		pepe.agregarDispositivo(aire);
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
	public void estaEnR1YAlConsumir120NoSeRecategoriza() {
		pepe.recategorizar();
		Assert.assertEquals(pepe.categoria(), r1);
	}
}
