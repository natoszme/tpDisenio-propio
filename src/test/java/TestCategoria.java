import org.junit.Assert;
import org.junit.Test;

public class TestCategoria {
	
	//ojo que se esta repitiendo con TestCliente
	Categoria r1 = new CategoriaSinMinimo("r1", 150, 18.76, 0.644);
	Categoria r2 = new Categoria("r2", 150, 325, 35.32, 0.644);
	Categoria r3 = new Categoria("r3", 325, 400, 60.71, 0.681);
	Categoria r4 = new Categoria("r4", 400, 450, 71.74, 0.738);
	Categoria r8 = new Categoria("r8", 700, 1400, 545.96, 0.851);
	//TODO: revisar este feo 0
	Categoria r9 = new CategoriaSinMaximo("r9", 1400, 887.19, 0.851);
	
	@Test
	public void aR1LeCorrespondeElConsumo100() {
		Assert.assertTrue(r1.meCorrespondeElConsumo(100));
	}
	
	@Test
	public void aR1LeCorrespondeElConsumo150() {
		Assert.assertTrue(r1.meCorrespondeElConsumo(150));
	}
	
	@Test
	public void aR1LeCorrespondeElConsumo0() {
		Assert.assertTrue(r1.meCorrespondeElConsumo(0));
	}
	
	@Test
	public void aR2NoLeCorrespondeElConsumo150() {
		Assert.assertFalse(r2.meCorrespondeElConsumo(150));
	}
	
	@Test
	public void aR8LeCorrespondeElConsumo1400() {
		Assert.assertTrue(r8.meCorrespondeElConsumo(1400));
	}
	
	@Test
	public void aR9NoLeCorrespondeElConsumo1400() {
		Assert.assertFalse(r9.meCorrespondeElConsumo(1400));
	}
	
	@Test
	public void aR9LeCorrespondeElConsumo1400Con05() {
		Assert.assertTrue(r9.meCorrespondeElConsumo(1400.05));
	}
	
	@Test
	public void aR3NoLeCorrespondeElConsumo325() {
		Assert.assertFalse(r3.meCorrespondeElConsumo(325));
	}
}
