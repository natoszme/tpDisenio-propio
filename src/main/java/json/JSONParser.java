package json;
import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class JSONParser<Entidad> {		 
	
	public List<Entidad> importar(String rutaArchivo, Class<Entidad> tipoEntidad) {	
		
		File archivoJson = new File(rutaArchivo);
		ObjectMapper mapper = new ObjectMapper()
					.registerModule(new ParameterNamesModule())
					.registerModule(new Jdk8Module())
					.registerModule(new JavaTimeModule());
		List<Entidad> importados = new ArrayList<>();
		
		try {
			importados = mapper.readValue(archivoJson, mapper.getTypeFactory().constructCollectionType(ArrayList.class, tipoEntidad));
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