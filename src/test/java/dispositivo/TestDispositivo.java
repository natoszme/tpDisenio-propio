package dispositivo;

import org.junit.Assert;
import org.junit.Test;

import fixture.Fixture;

public class TestDispositivo extends Fixture {
	@Test
	public void candelabroNoEsInteligente() {
		Assert.assertFalse(candelabro.esInteligente());
	}
	@Test
	public void smartTvEsInteligente() {
		Assert.assertTrue(televisorSmart.esInteligente());
	}
}
