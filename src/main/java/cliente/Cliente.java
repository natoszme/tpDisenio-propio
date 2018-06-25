package cliente;
import java.awt.Point;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.optim.PointValuePair;

import categoria.Categoria;
import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;
import repositorio.RepoCategorias;

public class Cliente {
	String nombre;
	String apellido;
	TipoDocumento tipoDocumento;
	long nroDocumento;
	long telefono;
	String domicilio;
	LocalDate fechaAlta;
	Categoria categoria;
	List<Dispositivo> dispositivos = new ArrayList<>();
	private double puntos = 0;
	AdaptadorSimplexCliente adaptadorSimplex = new AdaptadorSimplexCliente(this);
	private Point ubicacion;
	
	public Cliente() { /*Es para el Json*/ }
	
	public Cliente(String nombre, String apellido, TipoDocumento tipoDocumento, long nroDocumento, long telefono, String domicilio, Categoria categoria, List<Dispositivo> dispositivos){
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.categoria = categoria;
		this.dispositivos = dispositivos;
		this.fechaAlta = LocalDate.now();
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
		this.seEncuentraEntreLosDispostivos(dispositivo);
		dispositivo.convertirAInteligente(dispositivoConcreto);
		puntos += 10;		
	}

	public void seEncuentraEntreLosDispostivos(Dispositivo dispositivo) {
		if (!dispositivos.stream().anyMatch(dispositiv -> dispositiv == dispositivo)) {
			throw new NoPuedeAfectarAUnDispositivoQueNoLePertenece();
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
	
	public PointValuePair resolucionSimplex() {
		
		PointValuePair resultado = adaptadorSimplex.getResolucionSimplex();
		return resultado;
		/*TODO hay que ver bien que hjaacer con el resultado, si se muestra o que onda
		 *Haciendo resultado.getPoint() devuelve un double[] con los resultados de todos los Xi
		 */		 
	}

	public double dameConsumoActual() {
		return dispositivos.stream().
				filter(Dispositivo::esInteligente).
				mapToDouble(Dispositivo::consumoActual).
				sum();
	}

	public Point getUbicacion() {
		return ubicacion;
	}
}