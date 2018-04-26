package categoria;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import repositorio.RepoCategorias;

public class TestJsonCategoria {
	
	List<Categoria> categorias;	
	
	@Before
	public void fixture() {
		RepoCategorias.getInstance().importarJSON();
		categorias = RepoCategorias.getInstance().obtenerTodas();
	}
	
	@Test
	public void laPrimerCategoriaEsR1() {
		System.out.print(categorias.get(0).getNombre());
		Assert.assertEquals("R1", categorias.get(0).getNombre());
	}
	
	@Test
	public void elConsumoMaximoDeLaPrimerCategoriaEs150() {
		Assert.assertEquals(150, categorias.get(0).getConsumoMaximo(), 0);
	}
}