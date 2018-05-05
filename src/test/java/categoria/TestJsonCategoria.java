package categoria;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import importacion.ImportadorCategorias;
import repositorio.RepoCategorias;

public class TestJsonCategoria {
	static List<Categoria> categorias;
	
	@BeforeClass
	public static void fixture() {
		ImportadorCategorias.getInstance().importarJSON();
		categorias = RepoCategorias.getInstance().obtenerTodas();
	}
	
	@Test
	public void laPrimerCategoriaEsR1() {
		Assert.assertEquals("R1", categorias.get(0).getNombre());
	}
	
	@Test
	public void elConsumoMaximoDeLaPrimerCategoriaEs150() {
		Assert.assertEquals(150, categorias.get(0).getConsumoMaximo(), 0);
	}
	
	 @Test
	 public void laCantidadDeCategoriasCargadasEs9() {
		 Assert.assertEquals(9, categorias.size());
	 }
}