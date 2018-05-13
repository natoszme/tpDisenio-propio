package dispositivo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import tipoDispositivo.DispositivoEstandar;
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
	
	public void convertirAInteligente() {
		tipoDispositivo.convertirAInteligente(this);
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
	
	public double consumo() {
		return tipoDispositivo.consumo();
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

	//si solo se va a usar para converitrEnInteligente, estaria bueno que se restrinja el tipo a Inteligente
	public void cambiarTipo(DispositivoInteligente dispositivoInteligente) {
		tipoDispositivo = dispositivoInteligente;		
	}
}
