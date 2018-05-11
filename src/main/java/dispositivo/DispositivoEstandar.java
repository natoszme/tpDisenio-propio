package dispositivo;

public class DispositivoEstandar extends Dispositivo{
	 
//constructor	
	public DispositivoEstandar(String nombre, double kwPorHora, double horasEncendido) {
		super(nombre,kwPorHora,horasEncendido);
	}

//definicion de los metodos abstractos	
	
	public double consumo() {
		return horasEncendido * kwPorHora;
	}
	
	public boolean esInteligente() {
		return false;
	}
	
	public boolean estaEncendido() { 
		return false;
	}

}
