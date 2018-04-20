import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
	String nombre;
	String apellido;
	TIPO_DOCUMENTO tipoDocumento;
	long nroDocumento;
	long telefono;
	String domicilio;
	LocalDate fechaAlta;
	Categoria categoria;
	List<Dispositivo> dispositivos = new ArrayList<>();
	
	public Usuario(String nombre, String apellido, TIPO_DOCUMENTO tipoDocumento, long nroDocumento, long telefono, String domicilio, Categoria categoria, List<Dispositivo> dispositivos){
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.categoria = categoria;
		this.dispositivos = dispositivos;
		this.fechaAlta = fechaDeHoy();
	}
	
	private LocalDate fechaDeHoy() {
		return LocalDate.now();
	}
	
	public boolean algunDispositivoEncendido() {
		return dispositivos.stream().anyMatch(Dispositivo::estaEncendido);
	}
	
	public int cantidadEncendidos() {
		return dispositivos.stream().filter(Dispositivo::estaEncendido).collect(Collectors.toList()).size();
	}
	
	public int cantidadApagados() {
		return cantidadDispositivos() - cantidadEncendidos();
	}
	
	public int cantidadDispositivos() {
		return dispositivos.size();
	}
	
	public void recategorizar() {
		categoria = obtenerNuevaCategoria(consumoHastaElMomento());
	}
	
	private Categoria obtenerNuevaCategoria(double consumo) {
		return RepoCategorias.getInstance().obtenerCategoriaSegunConsumo(consumo);
	}
	
	public double consumoHastaElMomento() {
		return dispositivos.stream().mapToDouble(Dispositivo::consumo).sum();
	}

	public void agregarDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);		
	}

	public Categoria categoria() {
		return categoria;
	}

	public String mostrar() {
		return nombre + " " +  apellido;
	}
}
