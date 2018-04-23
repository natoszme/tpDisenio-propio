import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCargaDeUsuarios {
	Categoria r2 = new Categoria("r2", 150, 325, 35.32, 0.644);
	Categoria r3 = new Categoria("r3", 325, 400, 60.71, 0.681);
	Usuario lio = new Usuario("lio", "messi", TIPO_DOCUMENTO.DNI, 40216458, 10101010, "Av. Catalunia 10", r2, new ArrayList<Dispositivo>());
	
	List<Usuario> usuarios;
	
	@Before
	public void fixture() {
		RepoUsuarios.getInstance().cargarUsuarios();
		usuarios = RepoUsuarios.getInstance().obtenerTodos();
	}
	
	@Test
	public void elNombreDelPrimerUsuarioEsLio() throws IOException {
		Assert.assertEquals(lio.getNombre(), usuarios.get(0).getNombre());
	}
	
	@Test
	public void elApellidoDeLioEsMessi() throws IOException {
		Assert.assertEquals(lio.getApellido(), usuarios.get(0).getApellido());
	}
	
	@Test
	public void elTipoDeDocumentoDeLioEsDNI() {
		Assert.assertEquals(lio.getTipoDocumento(), usuarios.get(0).getTipoDocumento());
	}
	
	@Test
	public void elDNIdeLioEs40216458() {
		Assert.assertEquals(lio.getNroDocumento(), usuarios.get(0).getNroDocumento());
	}
	
	@Test
	public void elTelefonoDeLioES10101010() {
		Assert.assertEquals(lio.getTelefono(), usuarios.get(0).getTelefono());
	}
	
	@Test
	public void elDomicilionDeLioEsAvCatalunia() {
		Assert.assertEquals(lio.getDomicilio(), usuarios.get(0).getDomicilio());
	}
	
	//no se puede usar assertEquals compara por identidad, no igualdad
	@Test
	public void laCategoriaDeLioEsR3() {
		Assert.assertEquals(r3.getNombre(), usuarios.get(0).getCategoria().getNombre());
	}
}
