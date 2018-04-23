import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CargarDataDesdeJSON {
	
	private static CargarDataDesdeJSON cargarData;
	
	public static CargarDataDesdeJSON getInstance() {
		if (cargarData == null) {
			return new CargarDataDesdeJSON();
		}
		return cargarData;
	}
	
	public void cargar() throws IOException{	
		File jsonInputFile = new File("./data/usuarios.json");
		ObjectMapper mapper = new ObjectMapper();
		List<Usuario> usuarios = mapper.readValue(jsonInputFile, new TypeReference<List<Usuario>>(){});
		RepoUsuarios.getInstance().agregarUsuarios(usuarios);
	}
}
