package cliente;
import static org.junit.Assert.*;

import org.junit.Test;

import fixture.Fixture;
import categoria.Categoria;

public class TestCliente extends Fixture {	
	@Test
	public void elClienteAlejandroTieneAlgunDispositivoEncendido() {
		assertTrue(alejandro.cantidadDispositivosEncendidos()>0);
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
		assertEquals(2, alejandro.cantidadDispositivos());
	}
	
	@Test
	public void inicialmenteAlejandroEsCategoriaR1() {
		assertEquals("R1",alejandro.categoria().getNombre());
	}	

	@Test
	public void alAgregarleAAlejandroUnDispositivoSinHorasPrendidoSuConsumoNoCambia() {
		double consumoActual = alejandro.consumoEnLasUltimas(2);
		alejandro.agregarDispositivo(microondas);
		assertEquals(consumoActual, alejandro.consumoEnLasUltimas(2), 0);
	}
	@Test
	public void alAgregarleAAlejandroUnDispositivoSinHorasPrendidoSuCategoriaNoCambia() {
		Categoria categoriaActual = alejandro.categoria();
		alejandro.agregarDispositivo(microondas);
		alejandro.recategorizarSegunUso(2);
		assertEquals(categoriaActual.getNombre(), alejandro.categoria().getNombre());
	}
	@Test
	public void alAgregarseTelevisorAAleandroEsCategoriarR2() {
		alejandro.agregarDispositivo(televisor);
		alejandro.recategorizarSegunUso(2);
		assertEquals("R2" ,alejandro.categoria().getNombre());
	}
	
	@Test
	public void seAgregaEquipoDeMusicaAAlejandroYAlRecategorizarEsR3() {
		alejandro.agregarDispositivo(equipoMusica);
		alejandro.recategorizarSegunUso(2);
		assertEquals("R3", alejandro.categoria().getNombre());
	}
	
	@Test
	public void seAgregaDvdAAlejandroYAlRecategorizarEsR4() {
		alejandro.agregarDispositivo(dvd);
		alejandro.recategorizarSegunUso(2);
		assertEquals("R4", alejandro.categoria().getNombre());
	}
	
	@Test
	public void seAgregaPlay4AAlejandroYAlRecategorizarEsR9() {
		alejandro.agregarDispositivo(play4);
		alejandro.recategorizarSegunUso(2);
		assertEquals("R9", alejandro.categoria().getNombre());
	}
}