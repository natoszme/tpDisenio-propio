package JSONParser;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import categoria.Categoria;
import cliente.Cliente;
import json.JSONParser;
import json.NoSePudoImportarJSONException;

public class TestJSONParser {
	@Test(expected = NoSePudoImportarJSONException.class)
	public void alPasarMalLaRutaDeCategoriasTiraExcepcion() {
		new JSONParser<Categoria>().importar("unaRutaMala.json", Categoria.class);
	}
	
	@Test(expected = NoSePudoImportarJSONException.class)
	public void alPasarMalLaRutaDeClientesTiraExcepcion() {
		new JSONParser<Cliente>().importar("./data/cliente.json", Cliente.class);
	}
	
	@Test
	public void alPasarBienLaRutaDeClientesDevuelveBien() {
		List<Cliente> clientesParseados = new JSONParser<Cliente>().importar("./resources/jsonData/clientes.json", Cliente.class);
		Assert.assertEquals("lio", clientesParseados.get(0).getNombre());
	}
	
	@Test
	public void alPasarBienLaRutaDeCategoriasDevuelveBien() {
		List<Categoria> clientesParseados = new JSONParser<Categoria>().importar("./resources/jsonData/categorias.json", Categoria.class);
		Assert.assertEquals("R1", clientesParseados.get(0).getNombre());
	}
}
