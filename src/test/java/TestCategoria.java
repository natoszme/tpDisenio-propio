import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCategoria extends Fixture {
	
	@Before
	public void init() {
		iniciarFixture();
	}
	
	@Test
	public void aR1LeCorrespondeElConsumo100() {
		Assert.assertTrue(r1.meCorrespondeElConsumo(100));
	}
	
	@Test
	public void aR1LeCorrespondeElConsumo150() {
		Assert.assertTrue(r1.meCorrespondeElConsumo(150));
	}
	
	@Test
	public void aR1LeCorrespondeElConsumo0Con01() {
		Assert.assertTrue(r1.meCorrespondeElConsumo(0.01));
	}
	
	@Test
	public void aR1LeCorrespondeElConsumo0() {
		Assert.assertTrue(r1.meCorrespondeElConsumo(0));
	}
	
	@Test
	public void aR1LeCorrespondeElConsumo10() {
		Assert.assertTrue(r1.meCorrespondeElConsumo(10));
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
	public void aR9LeCorrespondeElConsumo1401Con05() {
		Assert.assertTrue(r9.meCorrespondeElConsumo(1401.05));
	}
	
	@Test
	public void aR3NoLeCorrespondeElConsumo325() {
		Assert.assertFalse(r3.meCorrespondeElConsumo(325));
	}
}
