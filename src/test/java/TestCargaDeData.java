import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TestCargaDeData {
	@Test
	public void elNombreDelPrimerUsuarioEsLio() throws IOException {
		Assert.assertEquals("lio", CargarDataDesdeJSON.getInstance().cargar());
	}
}
