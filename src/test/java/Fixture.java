import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fixture {
	Categoria r1, r2, r3, r4, r5, r6, r7, r8;
	CategoriaSinMaximo r9;
	Dispositivo candelabro, televisor, microondas,equipoMusica ,dvd, play4;
	List<Dispositivo> dispositivos = new ArrayList<>();
	Cliente alejandro, lio, pepe, nico;
	
	public void iniciarFixture() {
		  r1 = new CategoriaSinMinimo("R1",150.0,18.76,0.644);			
		  r2 = new Categoria("R2",150.0,325.0,35.32,0.644);			
		  r3 = new Categoria("R3",326.0,400.0,60.71,0.681);			
		  r4 = new Categoria("R4",400.0,450.0,71.74,0.783);			
		  r5 = new Categoria("R5",450.0,500.0,110.38,0.794);			
		  r6 = new Categoria("R6",500.0,600.0,220.75,0.832);			
		  r7 = new Categoria("R7",600.0,700.0,443.59,0.851);			
		  r8 = new Categoria("R8",700.0,1400.0,545.19,0.851);				
		  r9 = new CategoriaSinMaximo("R9",1400.0,545.19,0.851); 
				
		  candelabro = new Dispositivo("Candelabro",60.9,true,2);	
		  televisor = new Dispositivo("Televisor",67.5,true,1);	  
		  microondas = new Dispositivo("Microondas", 1402.0, false, 0);
		  equipoMusica = new Dispositivo ("Equipo de musica", 270.0,true,1);
		  dvd = new Dispositivo("DVD",300.77,true,1);
		  play4 = new Dispositivo("Play station 4", 1401.05, true, 1);
		
		  dispositivos = new ArrayList<Dispositivo>();	
		  dispositivos.add(candelabro);
		
		  alejandro = new Cliente("Alejandro","Saez", TIPO_DOCUMENTO.DNI,3876675,43543245,"Macos Sastre 324",r1, dispositivos);
		  Cliente nico = new Cliente("nico", "otamendi", TIPO_DOCUMENTO.DNI, 35102594, 42012594, "Av. Siempre Viva 20", r1, new ArrayList<Dispositivo>());
		  Cliente pepe = new Cliente("pepe", "argento", TIPO_DOCUMENTO.CI, 12549785, 40000001, "Manuel Rodriguez 1251", r1, new ArrayList<Dispositivo>());
		  Cliente lio = new Cliente("lio", "messi", TIPO_DOCUMENTO.DNI, 40216458, 10101010, "Av. Catalunia 10", r2, new ArrayList<Dispositivo>());
		  RepoCategorias.getInstance().setCategorias(Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9));	

	}
	
}
