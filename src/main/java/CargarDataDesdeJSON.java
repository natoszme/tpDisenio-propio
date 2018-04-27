import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CargarDataDesdeJSON<Entidad> {
	
	private static CargarDataDesdeJSON cargarData;
	
	public List<Entidad> obtenerElementos(String ruta, Class<Entidad> tClass) {	
		File archivoJson = new File(ruta);
		ObjectMapper mapper = new ObjectMapper();
		List<Entidad> elementos = new ArrayList<>();
		
		try {
			elementos = mapper.readValue(archivoJson, mapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass));
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
		
		return elementos;
	}
}
