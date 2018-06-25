package importador;

import java.awt.Point;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	public void laPrimerUbicacionEs1_1() {		
		Assert.assertEquals(new Point (1, 1), transformadores.get(0).ubicacion());
	}
}