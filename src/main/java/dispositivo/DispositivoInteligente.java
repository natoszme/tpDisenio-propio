package dispositivo;
import dispositivo.EstadoDelDispositivo;

public class DispositivoInteligente extends Dispositivo {
	
	EstadoDelDispositivo estado;

//constructor	
	public DispositivoInteligente(String nombre, double kwPorHora, EstadoDelDispositivo estado, double horasEncendido) {
		super(nombre,kwPorHora,horasEncendido);
		this.estado = estado;
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
		return estado.estaEncendido();
	}
	
	//public boolean isEncendido() {
	//	return encendido;
	//}

} 