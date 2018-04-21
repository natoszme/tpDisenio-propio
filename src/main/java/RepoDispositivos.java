import java.util.ArrayList;
import java.util.List;

//import com.fasterxml.jackson.databind.JsonNode;

public class RepoDispositivos {
	private static RepoDispositivos repoDispositivos;
	private static List<Dispositivo> dispositivos = new ArrayList<>();
	
	public static RepoDispositivos getInstance(){
		if (repoDispositivos == null) {
			repoDispositivos = new RepoDispositivos();
		}
		return repoDispositivos;
	}
	
	public List<Dispositivo> obtenerTodos() {
		return dispositivos;
	}

	public void agregarDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);
	}
}