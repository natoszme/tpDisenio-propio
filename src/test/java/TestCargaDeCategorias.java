import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCargaDeCategorias {
	
	Categoria r1 = new CategoriaSinMinimo("r1", 0, 150, 18.76, 0.644);
	Categoria r2 = new Categoria("r2", 150, 325, 35.32, 0.644);
	List<Categoria> categorias;
	
	
	@Before
	public void fixture() {
		RepoCategorias.getInstance().cargarCategorias();
		categorias = RepoCategorias.getInstance().obtenerTodas();
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
