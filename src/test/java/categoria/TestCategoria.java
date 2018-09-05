package categoria;
import org.junit.Assert;
import org.junit.Test;

import fixture.Fixture;

public
class TestCategoria extends Fixture {

	@Test
	public void aR1LeCorrespondeElConsumo150() {
		Assert.assertTrue(r1.meCorrespondeElConsumo(150));
	}

	@Test
	public void aR1LeCorrespondeElConsumo0Con01() {
		Assert.assertTrue(r1.meCorrespondeElConsumo(0.01));
	}
	
	@Test
	public void aR9LeCorrespondeElConsumo1909Con55() {
		Assert.assertTrue(r9.meCorrespondeElConsumo(1909.55));
	}
	
	@Test
	public void aR1NoLeCorrespondeElConsumo0() {
		Assert.assertFalse(r1.meCorrespondeElConsumo(0));
	}	
}