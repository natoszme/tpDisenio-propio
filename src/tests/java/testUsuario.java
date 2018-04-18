import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class testUsuario {
	
	Categoria r1 = new Categoria("r1", 0, 150, 18.76, 0.644);
	Usuario nico = new Usuario("nico", "otamendi", TIPO_DOCUMENTO.DNI, 35102594, 42012594, "Av. Siempre Viva 20", r1, new ArrayList<Dispositivo>());
	Usuario pepe = new Usuario("pepe", "argento", TIPO_DOCUMENTO.CI, 12549785, 40000001, "Manuel Rodriguez 1251", r1, new ArrayList<Dispositivo>());
	
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
}
