import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

public class TestCliente extends Fixture {
	
	
	@Before
	public void init() {
		iniciarFixture();
	}

	@Test
	public void elClienteAlejandroTieneAlgunDispositivoEncendido() {
		assertEquals(0, alejandro.cantidadDispositivosApagados());
	}
	
	@Test
	public void elClienteAlejandroTiene0DispositivosApagados() {
		assertEquals(0, alejandro.cantidadDispositivosApagados());
	}
	@Test
	public void elClienteAlejandroTiene1DispositivoInicialmente() {
		assertEquals(1, alejandro.cantidadDispositivos());
	}
		
	@Test
	public void con1DispositivoMasAlejandroTiene2() {
		alejandro.agregarDispositivo(televisor);
		assertEquals(2,alejandro.cantidadDispositivos());
	}
	
	@Test
	public void inicialmenteAlejandroEsCategoriaR1() {
		assertEquals("R1",alejandro.categoria().getNombre());
	}	

	@Test
	public void alAgregarleAAlejandroUnDispositivoSinHorasPrendidoSuConsumoNoCambia() {
		double consumoActual = alejandro.consumoHastaElMomento();
		alejandro.agregarDispositivo(microondas);
		assertEquals(consumoActual, alejandro.consumoHastaElMomento(), 0);
	}
	@Test
	public void alAgregarleAAlejandroUnDispositivoSinHorasPrendidoSuCategoriaNoCambia() {
		Categoria categoriaActual = alejandro.categoria();
		alejandro.agregarDispositivo(microondas);
		alejandro.recategorizar();
		assertEquals(categoriaActual, alejandro.categoria());
	}
	@Test
	public void alAgregarseTelevisorAAleandroEsCategoriarR2() {
		alejandro.agregarDispositivo(televisor);
		alejandro.recategorizar();
		assertEquals("R2",alejandro.categoria().getNombre());
	}
	
	@Test
	public void seAgregaEquipoDeMusicaAAlejandroYAlRecategorizarEsR3() {
		alejandro.agregarDispositivo(equipoMusica);
		alejandro.recategorizar();
		assertEquals("R3",alejandro.categoria().getNombre());
	}
	
	@Test
	public void seAgregaDvdAAlejandroYAlRecategorizarEsR4() {
		alejandro.agregarDispositivo(dvd);
		alejandro.recategorizar();
		assertEquals("R4",alejandro.categoria().getNombre());
	}
	
	@Test
	public void seAgregaPlay4AAlejandroYAlRecategorizarEsR9() {
		alejandro.agregarDispositivo(play4);
		alejandro.recategorizar();
		assertEquals("R9",alejandro.categoria().getNombre());
	}
}