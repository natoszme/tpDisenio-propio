package cliente;
import java.nio.file.DirectoryStream.Filter;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import categoria.Categoria;
import dispositivo.Dispositivo;
import dispositivo.DispositivoInteligente;
import dispositivo.DispositivoEstandar;
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
	
	public boolean algunDispositivoEncendido() {
		return this.cantidadDispositivosEncendidos() > 0;
	}
	
	public long cantidadDispositivosEncendidos() {	
		return  dispositivos.stream().filter(Dispositivo::esInteligente).filter(Dispositivo::estaEncendido).count(); 
	}
	/*el filtro de esInteligente no me sirve porque me devuelve una lista de tipo Dispositvo, de la interfaz.Por lo tanto,
	despues tengo que filtrar una lista de ese mismo tipo(tengo que poner en la interfaz el metodo estaEncendido, que en
	realidad no deberia estar en los dispositivoEstandar)*/
	
	/*
	 * public List<Dispositivo> misDispositivosInteligentes(){
		return  dispositivos.stream().filter(Dispositivo::esInteligente);
	}*/
	
	//habia intentado hacer hacer el primer filter en ese metodo pero me tiraba un error que no podia convertir un Stream en List 
	
	public long cantidadDispositivosInteligentes() {
		return dispositivos.stream().filter(Dispositivo::esInteligente).count();
	}
	
	public long cantidadDispositivosApagados() {
		return cantidadDispositivosInteligentes() - cantidadDispositivosEncendidos();
	}
	
	public long cantidadDispositivos() {
		return dispositivos.stream().count();
	}
	
	public void recategorizar() {
		categoria = obtenerNuevaCategoria(consumoHastaElMomento());
	}
	
	private Categoria obtenerNuevaCategoria(double consumo) {
		return RepoCategorias.getInstance().obtenerCategoriaSegunConsumo(consumo);
	}
	
	public double consumoHastaElMomento() {
		return dispositivos.stream().mapToDouble(Dispositivo::consumo).sum();
	}

	public void agregarDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);		
	}

	public Categoria categoria() {
		return this.categoria;
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
}