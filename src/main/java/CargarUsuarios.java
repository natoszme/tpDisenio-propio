import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CargarUsuarios implements TipoDato{
	public void cargarSegunTipo(File archivo, ObjectMapper mapper) throws JsonParseException, JsonMappingException, IOException {
		List<Usuario> usuarios = mapper.readValue(archivo, new TypeReference<List<Usuario>>(){});		
		RepoUsuarios.getInstance().agregarUsuarios(usuarios);
	}
}