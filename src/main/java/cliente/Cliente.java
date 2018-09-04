package cliente;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.uqbar.geodds.Point;

import categoria.Categoria;
import consumoMasivo.ConsumidorMasivo;
import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import model.DatosBasicos;
import repositorio.RepoCategorias;

@Entity
public class Cliente extends DatosBasicos implements ConsumidorMasivo {
	
	private String nombre;
	private String apellido;
	
	@Enumerated
	private TipoDocumento tipoDocumento;
	
	private long nroDocumento;
	private long telefono;
	private String domicilio;
	
	@Column
	private LocalDate fechaAlta;
	
	@OneToOne
	private Categoria categoria;
	
	//@OneToMany(fetch=FetchType.LAZY, mappedBy="dispositivo_id")
	@Transient
	private List<Dispositivo> dispositivos = new ArrayList<>();
	
	private double puntos = 0;
	private boolean ahorroAutomatico = true;  
	
	@Transient
	private Point ubicacion;
	
	public Cliente() {}
	
	public Cliente(String nombre, String apellido, TipoDocumento tipoDocumento, long nroDocumento, long telefono, String domicilio, Categoria categoria, List<Dispositivo> dispositivos, Point ubicacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.categoria = categoria;
		this.dispositivos = dispositivos;
		this.fechaAlta = LocalDate.now();
		this.ubicacion = ubicacion;
	}
	
	public boolean algunInteligenteEncendido() {
		return this.cantidadInteligentesEncendidos() > 0;
	}
	
	public long cantidadInteligentesEncendidos() {
		return dispositivos.stream().
				filter(Dispositivo::esInteligente).
				filter(Dispositivo::estaEncendido).count();
	}
	
	public long cantidadInteligentesEnAhorroEnergia() {
		return dispositivos.stream().
				filter(Dispositivo::esInteligente).
				filter(Dispositivo::estaEnAhorroEnergia).count();
	}
	
	public long cantidadDispositivosApagados() {
		return cantidadDispositivosInteligentes() - cantidadInteligentesEncendidos() - cantidadInteligentesEnAhorroEnergia();
	}

	public long cantidadDispositivosInteligentes() {
		return dispositivos.stream().filter(Dispositivo::esInteligente).count();
	}
	
	public long cantidadDispositivos() {
		return dispositivos.stream().count();
	}
	
	public void recategorizarSegunUso(int horasDeUso) {
		categoria = obtenerNuevaCategoria(consumoEnLasUltimas(horasDeUso));
	}
	
	private Categoria obtenerNuevaCategoria(double consumo) {
		return RepoCategorias.getInstance().obtenerCategoriaSegunConsumo(consumo);
	}
	
	public double consumoEnLasUltimas(int horas) {
		return dispositivos.stream().mapToDouble(dispositivo -> dispositivo.consumoEnLasUltimas(horas, dispositivo)).sum();
	}

	public void agregarDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);
		puntos += dispositivo.puntosPorRegistrar();
	}
	
	public void convertirAInteligente(Dispositivo dispositivo, DispositivoConcreto dispositivoConcreto) {
		this.tieneDispositivo(dispositivo);
		dispositivo.convertirAInteligente(dispositivoConcreto);
		puntos += 10;		
	}

	public void tieneDispositivo(Dispositivo dispositivo) {
		if (!dispositivos.stream().anyMatch(unDispositivo -> unDispositivo == dispositivo)) {
			throw new NoPuedeAfectarAUnDispositivoQueNoLePerteneceException();
		}
	}
	
	public Categoria categoria() {
		return this.categoria;
	}
	
	public double getPuntos(){
		return this.puntos;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}
	
	public long getNroDocumento() {
		return this.nroDocumento;
	}
	public long getTelefono(){
		return this.telefono;
	}
	public String getDomicilio() {
		return this.domicilio;
	}
	public LocalDate getFechaAlta() {
		return this.fechaAlta;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	public List<Dispositivo> getDispositivos(){
		return this.dispositivos;
	}
	
	public int getCantidadDispositivos(){
		return dispositivos.size();
	}

	public double consumoActual() {
		return dispositivos.stream().
				filter(Dispositivo::esInteligente).
				mapToDouble(Dispositivo::consumoActual).
				sum();
	}
	
	public boolean permiteAhorroAutomatico() {
		return ahorroAutomatico;
	}

	public Point ubicacion() {
		return ubicacion;
	}

	public void limpiarDispositivos() {
		dispositivos.clear();		
	}
}