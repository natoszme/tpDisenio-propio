package dispositivo;




public class DispositivoInteligente implements Dispositivo {
	String nombre;
	double kwPorHora;
	boolean encendido;
	double horasEncendido;
public DispositivoInteligente() {//json
		
	}
	public DispositivoInteligente(String nombre, double kwPorHora, boolean estado, double horasEncendido) {
		this.nombre = nombre;
		this.kwPorHora = kwPorHora;
		this.encendido = estado;
		this.horasEncendido = horasEncendido;
		
	}
	
//metodos de la interfaz
	
	public String getNombre() {
		return nombre;
	}
	public double getKwPorHora() {
		return kwPorHora;
	}
	public double getHorasEncendido(){
		return horasEncendido;
	}
	 public double consumo() {
			return horasEncendido * kwPorHora;
	}
	 public boolean esInteligente() {
		return false;
	}
//------------------------------------------
	 
	public boolean estaEncendido() {
		return encendido;
	}
	
	public boolean isEncendido() {
		return encendido;
	}

} 