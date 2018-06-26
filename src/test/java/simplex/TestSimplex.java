package simplex;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dispositivo.dispositivosBase.aire.Aire2200Frigorias;
import dispositivo.dispositivosBase.aire.Aire3500Frigorias;
import dispositivo.dispositivosBase.computadora.ComputadoraDeEscritorio;
import dispositivo.dispositivosBase.lavarropas.LavarropasAutomatico5kg;
import dispositivo.dispositivosBase.microondas.MicroondasConvencional;
import fixture.Fixture;

public class TestSimplex extends Fixture {
	
	@Before
	public void before() {
		Aire2200Frigorias aire = new Aire2200Frigorias(mockAireConcreto);
		Aire3500Frigorias aire3500 = new Aire3500Frigorias(mockAireConcreto);
		ComputadoraDeEscritorio compu = new ComputadoraDeEscritorio(mockPcConcreta);
		LavarropasAutomatico5kg lavarropas = new LavarropasAutomatico5kg(mockLavarropas);
		MicroondasConvencional microondas = new MicroondasConvencional(mockMicroondas);
		lio.agregarDispositivo(aire);
		lio.agregarDispositivo(aire3500);
		lio.agregarDispositivo(compu);
		lio.agregarDispositivo(lavarropas);
		lio.agregarDispositivo(microondas);
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(aire, 90, 360));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(compu, 90, 360));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(aire3500, 90, 360));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(lavarropas, 6, 30));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(microondas, 6, 15));
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