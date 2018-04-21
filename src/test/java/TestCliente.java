import static org.junit.Assert.*; 
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;

public class TestCliente {
	Categoria r1;
	Categoria r2;
	Categoria r3;
	Categoria r4;
	Categoria r5;
	Categoria r6;
	Categoria r7;
	Categoria r8;
	Categoria r9;
	Dispositivo candelabro;
	Dispositivo televisor;
	List<Dispositivo> dispositivos;
	Usuario alejandro;
	
	@Before
	public void init() {
				
		  r1 = new Categoria("R1",0.0,150.0,18.76,0.644);
				
		  r2 = new Categoria("R2",151.0,325.0,35.32,0.644);
				
		  r3 = new Categoria("R3",326.0,400.0,60.71,0.681);
				
		  r4 = new Categoria("R4",401.0,450.0,71.74,0.783);
				
		  r5 = new Categoria("R5",451.0,500.0,110.38,0.794);
				
		  r6 = new Categoria("R6",501.0,600.0,220.75,0.832);
				
		  r7 = new Categoria("R7",601.0,700.0,443.59,0.851);
				
		  r8 = new Categoria("R8",701.0,1400.0,545.19,0.851);	
				
		  r9 = new Categoria("R9",1401.0,998999999,545.19,0.851); 
				
		  candelabro = new Dispositivo("Candelabro",60.9,true,2);
		
		  televisor = new Dispositivo("Televisor",67.5,true,1);
		
		  dispositivos = new ArrayList<Dispositivo>();
		
		  dispositivos.add(candelabro);
		
		  alejandro = new Usuario("Alejandro","Saez", TIPO_DOCUMENTO.DNI,3876675,43543245,"Macos Sastre 324",r1, dispositivos);
		
		}
	

	@Test
	public void elClienteAlejandroTieneAlgunDispositivoEncendido() {
		assertEquals(0, alejandro.cantidadApagados());
	}
	
	@Test
	public void elClienteAlejandroTiene0DispositivosApagados() {
		assertEquals(0, alejandro.cantidadApagados());
	}
	@Test
	public void elClienteAlejandroTiene1DispositivoInicialmente() {
		assertEquals(1, alejandro.cantidadDispositivos());
	}
		
	@Test
	public void con1DispositivoMasAlejandroTiene2() {
		alejandro.agregarDispositivo(televisor);
		assertEquals(2,alejandro.cantidadDispositivos());
	}
	
	@Test
	public void inicialmenteAlejandroEsCategoriaR1() {
		assertEquals("R1",alejandro.categoria().getNombre());
	}
	
	@Test
	public void alAgregarseTelevisorAAleandroEsCategoriarR2() {
		alejandro.agregarDispositivo(televisor);
		alejandro.recategorizar();
		assertEquals("R2",alejandro.categoria().getNombre());
	}
	
	@Test
	public void yguhij() {
		
	}
	
	
}
