package dispositivo;

public abstract class Dispositivo {
	String nombre;
	double kwPorHora;
	double horasEncendido;
	
//json
	
public Dispositivo() {
		
	}
	
//constructor	
	
	public Dispositivo(String nombre, double kwPorHora, double horasEncendido) {
		this.nombre = nombre;
		this.kwPorHora = kwPorHora;
		this.horasEncendido = horasEncendido;
	}
	
	 public String getNombre() {
		return nombre;
	}
	public double getKwPorHora() {
		return kwPorHora;
	}
	public double getHorasEncendido(){
		return horasEncendido;
	}
	
//metodos abstractos
	
	public abstract double consumo();
	public abstract boolean esInteligente();
	
	public abstract boolean estaEncendido();//este hay que sacarlo cuando podamos filtrar la lista de dispoditivosInteligentes y que sean de ese tipo
	
	
}


