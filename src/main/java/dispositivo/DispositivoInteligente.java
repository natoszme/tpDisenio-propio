package dispositivo;

public class DispositivoInteligente extends Dispositivo {
	
	boolean encendido;

//constructor	
	public DispositivoInteligente(String nombre, double kwPorHora, boolean estado, double horasEncendido) {
		super(nombre,kwPorHora,horasEncendido);
		this.encendido = estado;
	}
	
//definicion de los metodos abstractos	
	
	 public double consumo() {
			return horasEncendido * kwPorHora;
	}
	 public boolean esInteligente() {
		return true;
	}
//------------------------------------------
	 
	public boolean estaEncendido() {
		return encendido;
	}
	
	//public boolean isEncendido() {
	//	return encendido;
	//}

} 