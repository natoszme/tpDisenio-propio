package json;
import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser<Entidad> {
	
	private ObjectMapper mapper = new ObjectMapper(); 
	
	public List<Entidad> obtenerImportados(String rutaArchivo) {	
		
		File archivo = new File(rutaArchivo + ".json");
		List<Entidad> importados = new ArrayList<>();
		
		try {
			importados = mapper.readValue(archivo, new TypeReference<List<Entidad>>(){});
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
		
		return importados;
	}

}