package fixture;
import java.util.ArrayList;


import java.util.List;

import org.junit.After;

import categoria.Categoria;
import cliente.Cliente;
import cliente.tipoDocumento;
import dispositivo.DispositivoInteligente;
import dispositivo.Dispositivo;
import dispositivo.DispositivoEstandar; // lo puse porq seguro vamos a agregar test que lo usen
import dispositivo.EstadoDelDispositivo;
import repositorio.RepoCategorias;

public class Fixture {
	protected Categoria r1, r2, r3, r4, r5, r6, r7, r8, r9;
	protected DispositivoInteligente candelabro, televisor, microondas,equipoMusica ,dvd, play4;
	protected List<Dispositivo> dispositivos = new ArrayList<>();
	protected Cliente alejandro, lio, pepe, nico;
	
	public Fixture() {
		  r1 = new Categoria("R1", 0, 150, 18.76, 0.644);			
		  r2 = new Categoria("R2", 150, 325, 35.32, 0.644);			
		  r3 = new Categoria("R3", 326, 400, 60.71, 0.681);			
		  r4 = new Categoria("R4", 400, 450, 71.74, 0.783);			
		  r5 = new Categoria("R5", 450, 500, 110.38, 0.794);			
		  r6 = new Categoria("R6", 500, 600, 220.75, 0.832);			
		  r7 = new Categoria("R7", 600, 700, 443.59, 0.851);			
		  r8 = new Categoria("R8", 700, 1400, 545.19, 0.851);				
		  r9 = new Categoria("R9",1400, Double.MAX_VALUE, 545.19, 0.851); 
				
		  candelabro = new DispositivoInteligente("Candelabro", 60.9, EstadoDelDispositivo.ENCENDIDO, 2);	
		  televisor = new DispositivoInteligente("Televisor", 67.5, EstadoDelDispositivo.ENCENDIDO, 1);	  
		  microondas = new DispositivoInteligente("Microondas", 1402.0, EstadoDelDispositivo.APAGADO, 0);
		  equipoMusica = new DispositivoInteligente ("Equipo de musica", 270.0, EstadoDelDispositivo.ENCENDIDO, 1);
		  dvd = new DispositivoInteligente("DVD", 300.77,EstadoDelDispositivo.ENCENDIDO, 1);
		  play4 = new DispositivoInteligente("Play station 4", 1401.05, EstadoDelDispositivo.ENCENDIDO, 1);
		
		  dispositivos = new ArrayList<Dispositivo>();	
		  dispositivos.add(candelabro);
		
		  alejandro = new Cliente("Alejandro", "Saez", tipoDocumento.DNI, 3876675, 43543245, "Macos Sastre 324", r1, dispositivos);
		  nico = new Cliente("nico", "otamendi", tipoDocumento.DNI, 35102594, 42012594, "Av. Siempre Viva 20", r1, new ArrayList<Dispositivo>());
		  pepe = new Cliente("pepe", "argento", tipoDocumento.CI, 12549785, 40000001, "Manuel Rodriguez 1251", r1, new ArrayList<Dispositivo>());
		  lio = new Cliente("lio", "messi", tipoDocumento.DNI, 40216458, 10101010, "Av. Catalunia 10", r2, new ArrayList<Dispositivo>());
		  RepoCategorias.getInstance().agregarEntidad(r1);
		  RepoCategorias.getInstance().agregarEntidad(r2);
		  RepoCategorias.getInstance().agregarEntidad(r3);
		  RepoCategorias.getInstance().agregarEntidad(r4);
		  RepoCategorias.getInstance().agregarEntidad(r5);
		  RepoCategorias.getInstance().agregarEntidad(r6);
		  RepoCategorias.getInstance().agregarEntidad(r7);
		  RepoCategorias.getInstance().agregarEntidad(r8);
		  RepoCategorias.getInstance().agregarEntidad(r9);
	}
	
	@After
	public void after() {
		RepoCategorias.getInstance().limpiarEntidades();
	}
}
