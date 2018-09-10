package dispositivo;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import db.DatosBasicos;
import tipoDispositivo.DispositivoInteligente;
import tipoDispositivo.TipoDispositivo;

@Entity
public class Dispositivo extends DatosBasicos{
	
	@Column(nullable = false)
	private String nombre;
	
	@OneToOne(optional = false)
	private TipoDispositivo tipoDispositivo;
	
	private double kwPorHora;
	
	public Dispositivo(String nombre, TipoDispositivo tipoDispositivo, double kwPorHora) {
		this.nombre = nombre;
		this.tipoDispositivo = tipoDispositivo;
		this.kwPorHora = kwPorHora;
	}
	
	public Dispositivo() {} /* Es para el JSON */
	
	public String getNombre() {
		return nombre;
	}
	
	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}
	
	public double getKwPorHora() {
		return kwPorHora;
	}
	
	public void convertirAInteligente(DispositivoConcreto dispositivoConcreto) {
		tipoDispositivo.convertirAInteligente(this, dispositivoConcreto);
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
	
	public double consumoEnLasUltimas(int horas, Dispositivo dispositivo) {
		return tipoDispositivo.consumoEnLasUltimas(horas, dispositivo);
	}
	
	public double estimacionDeConsumoEn(int horas) {
		return horas * kwPorHora;
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

	public double horasPrendidoEnMesActual() {
		return tipoDispositivo.horasPrendidoEnMesActual();
	}
	
	public double consumoActual() {
		return tipoDispositivo.consumoActual();
	}
	
	public boolean esIgualA(Dispositivo otroDispositivo) {
		return otroDispositivo.getNombre() == nombre;
	}

	public boolean esElMismoConcretoQue(Dispositivo dispositivo) {
		return tipoDispositivo.esElMismoConcretoQue(dispositivo);
	}
	
	public DispositivoConcreto dispositivoConcreto() {
		return tipoDispositivo.getDispositivoConcreto();
	}
}
