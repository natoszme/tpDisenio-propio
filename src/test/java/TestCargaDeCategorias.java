import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCargaDeCategorias extends FixtureGlobal{
	
	List<Categoria> categorias;	
	
	@Before
	public void fixture() {
		RepoCategorias.getInstance().cargarElementos();
		categorias = RepoCategorias.getInstance().obtenerTodos();
	}
	
	@Test
	public void laPrimerCategoriaEsR1() {
		Assert.assertEquals(r1.getNombre(), categorias.get(0).getNombre());
	}
	
	@Test
	public void elConsumoMaximoDeLaPrimerCategoriaEs150() {
		Assert.assertEquals(r1.getConsumoMaximo(), categorias.get(0).getConsumoMaximo(), 0);
	}
}
