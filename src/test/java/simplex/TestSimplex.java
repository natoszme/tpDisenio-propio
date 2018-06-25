package simplex;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dispositivo.dispositivosBase.aire.Aire2200Frigorias;
import fixture.Fixture;

public class TestSimplex extends Fixture {
	
	@Before
	public void before() {
		Aire2200Frigorias aire = new Aire2200Frigorias(mockAireConcreto);
		lio.agregarDispositivo(aire);
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(aire, 90, 360));
		
		//System.out.println(RepoRestriccionesUsoDispositivo.getInstance().dameRestriccionMaximaDe(aire));
		
		/*lio.agregarDispositivo(new ComputadoraDeEscritorio(mockPcConcreta));
		lio.agregarDispositivo(new TelevisorLed40(mockTelevisorSmartConcreto));
		lio.agregarDispositivo(new LamparaDe20W(mockLampara));
		lio.agregarDispositivo(new LavarropasAutomatico5kg(mockLavarropas));
		lio.agregarDispositivo(new PlanchaAVapor(mockPlancha));
		lio.agregarDispositivo(new VentiladorDeTecho(mockVentilador));
		lio.agregarDispositivo(new MicroondasConvencional(mockMicroondas));*/
	}

	@Test
	public void simplex() {
		//TODO reveer si nos conviene usar un singleton para no instanciar todo el tiempo
		OptimizadorUsoDispositivos optimizadorDeLio = new OptimizadorUsoDispositivos(lio);
		for (double elem : optimizadorDeLio.optimizarUsoDispositivos().getPoint()) {        	
        	System.out.println(elem);        	
        }
	}
}