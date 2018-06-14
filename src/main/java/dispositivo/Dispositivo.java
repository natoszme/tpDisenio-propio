package dispositivo;
import java.time.LocalDateTime;

import tipoDispositivo.DispositivoInteligente;
import tipoDispositivo.TipoDispositivo;

public class Dispositivo {
	private String nombre;
	private TipoDispositivo tipoDispositivo;
	
	public Dispositivo(String nombre, TipoDispositivo tipoDispositivo) {
		this.nombre = nombre;
		this.tipoDispositivo = tipoDispositivo;
	}
	
	public Dispositivo() {} /* Es para el JSON */
	
	public String getNombre() {
		return nombre;
	}
	
	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}
	
	public void convertirAInteligente(long identificadorFabrica, DispositivoConcreto fabricante) {
		tipoDispositivo.convertirAInteligente(this, identificadorFabrica, fabricante);
	}
	
	public boolean esInteligente() {
		return tipoDispositivo.esInteligente();
	}
	
	public boolean estaEncendido() {
		return tipoDispositivo.estaEncendido();
	}
	
	public boolean estaEnAhorroEnergia() {
		return tipoDispositivo.estaEnAhorroEnergia();
	}
	
	public boolean estaApagado() {
		return tipoDispositivo.estaApagado();
	}
	
	public double consumoEnLasUltimas(int horas) {
		return tipoDispositivo.consumoEnLasUltimas(horas);
	}
	
	public double puntosPorRegistrar() {
		return tipoDispositivo.puntosPorRegistrar();
	}
	
	public void apagar() {
		tipoDispositivo.apagar();
	}
	
	public void encender() {
		tipoDispositivo.encender();
	}
	
	public void ponerEnAhorroDeEnergia() {
		tipoDispositivo.ponerEnAhorroDeEnergia();
	}
	
	public void cambiarTipo(DispositivoInteligente dispositivoInteligente) {
		tipoDispositivo = dispositivoInteligente;		
	}
	
	public void guardarConsumoDeFecha(LocalDateTime fecha, double consumo) {
		tipoDispositivo.guardarConsumoDeFecha(fecha, consumo);
	}
	
	//TODO es posible que haya que retocar este metodo, depende de como se traten a los conjuntos de dispositivos (ej: todas las tv's)
	public boolean equals(Dispositivo otroDispositivo) {
		return this.nombre == otroDispositivo.nombre;
	}
}
