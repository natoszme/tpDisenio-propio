import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		return dispositivos.stream().anyMatch(dispositivo -> dispositivo.estaEncendido());
	}
	
	public long cantidadEncendidos() {
		return dispositivos.stream().filter(Dispositivo::estaEncendido).count();
	}
	
	public long cantidadApagados() {
		return cantidadDispositivos() - cantidadEncendidos();
	}
	
	public long cantidadDispositivos() {
		return dispositivos.stream().count();
	}
}
