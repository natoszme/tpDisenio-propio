import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CargarDataDesdeJSON {
	
	private static CargarDataDesdeJSON cargarData;
	private static TipoDato tipoDato;
	
	public static CargarDataDesdeJSON getInstance() {
		if (cargarData == null) {
			return new CargarDataDesdeJSON();
		}
		return cargarData;
	}
	
	public void setTipoDato(TipoDato tipoDato) {
		this.tipoDato = tipoDato;
	}
	
	public void cargar(String nombreArchivo) {	
		File archivoJson = new File("./data/" + nombreArchivo + ".json");
		ObjectMapper mapper = new ObjectMapper();
		
		//hay alguna forma de pasar la clase por parametro?
		/*List<Usuario> usuarios = mapper.readValue(archivoJson, new TypeReference<List<Usuario>>(){});
		RepoUsuarios.getInstance().agregarUsuarios(usuarios);*/
		
		//se agregar para no propagar el throes IOException en los metodos que llamen a este
		try {
			tipoDato.cargarSegunTipo(archivoJson, mapper);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

interface TipoDato{
	public void cargarSegunTipo(File archivo, ObjectMapper mapper) throws JsonParseException, JsonMappingException, IOException;
}
