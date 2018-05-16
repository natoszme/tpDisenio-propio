package cliente;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import fixture.Fixture;
import categoria.Categoria;

public class TestCliente extends Fixture {	
	@Test
	public void elClienteAlejandroTiene1DispositivoApagado() {
		assertEquals(1, alejandro.cantidadDispositivosApagados());
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
	public void alAgregarleAAlejandroUnDispositivoConMuchoConsumoPasaAR8() {
		alejandro.agregarDispositivo(microondas);
		alejandro.recategorizarSegunUso(2);
		assertEquals("R8", alejandro.categoria().getNombre());
	}
	@Test
	public void alAgregarleAAlejandroUnDispositivoSuCategoriaCambia() {
		Categoria categoriaActual = alejandro.categoria();
		alejandro.agregarDispositivo(microondas);
		alejandro.recategorizarSegunUso(2);
		assertFalse(alejandro.categoria().getNombre() == categoriaActual.getNombre());
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
	public void seAgregaDvdAAlejandroYAlRecategorizarEsR7() {
		alejandro.agregarDispositivo(dvd);
		alejandro.recategorizarSegunUso(2);
		assertEquals("R7", alejandro.categoria().getNombre());
	}
	
	@Test
	public void seAgregaPlay4AAlejandroYAlRecategorizarEsR8() {
		alejandro.agregarDispositivo(play4);
		alejandro.recategorizarSegunUso(2);
		assertEquals("R8", alejandro.categoria().getNombre());
	}
}