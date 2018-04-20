import java.io.File;
import java.io.IOException;
import java.util.List;

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
	
	public String cargar() throws IOException{
		/*ObjectMapper objectMapper = new ObjectMapper();
		//Usuario usuario = objectMapper.readValue(new File("c:\\file.json"), Usuario.class);
		File jsonInputFile = new File("/Users/java2novice/jsonInput.txt");
		JsonNode rootNode = objectMapper.readTree(jsonInputFile)
		JsonNode drNode = rootNode.path("direct_reports");
        Iterator<JsonNode> itr = drNode.getElements();
        System.out.println("\nDirect reports:");
            while (itr.hasNext()) {
                JsonNode temp = itr.next();
                System.out.println(temp.getTextValue());
            }*/
		
		File jsonInputFile = new File("./data/usuarios.json");
		ObjectMapper mapper = new ObjectMapper();
		List<Usuario> usuarios = mapper.readValue(jsonInputFile, new TypeReference<List<Usuario>>(){});
		return usuarios.get(0).nombre;
	}
}
