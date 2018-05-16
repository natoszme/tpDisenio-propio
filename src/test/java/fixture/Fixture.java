package fixture;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;

import categoria.Categoria;
import cliente.Cliente;
import cliente.TipoDocumento;
import dispositivo.Dispositivo;
import repositorio.RepoCategorias;
import tipoDispositivo.DispositivoEstandar;
public class Fixture {
	protected Categoria r1, r2, r3, r4, r5, r6, r7, r8, r9;
	protected Dispositivo candelabro, televisor, microondas,equipoMusica ,dvd, play4, televisorSmart;
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
				
		  candelabro = new Dispositivo("Candelabro", new DispositivoEstandar(9));
		  televisor = new Dispositivo("Televisor", new DispositivoEstandar(67.5));	  
		  microondas = new Dispositivo("Microondas", new DispositivoEstandar(1402.0));
		  equipoMusica = new Dispositivo ("Equipo de musica", new DispositivoEstandar(270.0));
		  dvd = new Dispositivo("DVD", new DispositivoEstandar(300.77));
		  play4 = new Dispositivo("Play station 4", new DispositivoEstandar(1401.05));  
		  
		  //TODO revisar si se puede sacar esto, ya esta arriba!
		  dispositivos = new ArrayList<Dispositivo>();	
		  dispositivos.add(candelabro);
		
		  alejandro = new Cliente("Alejandro", "Saez", TipoDocumento.DNI, 3876675, 43543245, "Macos Sastre 324", r1, dispositivos);
		  nico = new Cliente("nico", "otamendi", TipoDocumento.DNI, 35102594, 42012594, "Av. Siempre Viva 20", r1, new ArrayList<Dispositivo>());
		  pepe = new Cliente("pepe", "argento", TipoDocumento.CI, 12549785, 40000001, "Manuel Rodriguez 1251", r1, new ArrayList<Dispositivo>());
		  lio = new Cliente("lio", "messi", TipoDocumento.DNI, 40216458, 10101010, "Av. Catalunia 10", r2, new ArrayList<Dispositivo>());
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
