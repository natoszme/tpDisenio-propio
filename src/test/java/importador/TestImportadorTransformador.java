package importador;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import transformador.Transformador;
import importacion.ImportadorTransformadores;
import repositorio.RepoTransformadores;

public class TestImportadorTransformador {
	static List<Transformador> transformadores;

	@Before
	public void fixture() {
		ImportadorTransformadores.getInstance().importarJSON();
		transformadores = RepoTransformadores.getInstance().obtenerTodas();
	}

	@Test
	public void laUbicacionDelPrimerTransformadorEs1_1() {		
		Assert.assertEquals(new Point (1, 1).getX(), transformadores.get(0).ubicacion().getX(), 0);
		Assert.assertEquals(new Point (1, 1).getY(), transformadores.get(0).ubicacion().getY(), 0);
	}
}