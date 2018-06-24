package simplex;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dispositivo.dispositivosBase.aire.Aire2200Frigorias;
import dispositivo.dispositivosBase.aire.Aire3500Frigorias;
import dispositivo.dispositivosBase.computadora.ComputadoraDeEscritorio;
import dispositivo.dispositivosBase.lampara.LamparaDe20W;
import dispositivo.dispositivosBase.lavarropas.LavarropasAutomatico5kg;
import dispositivo.dispositivosBase.microondas.MicroondasConvencional;
import dispositivo.dispositivosBase.plancha.PlanchaAVapor;
import dispositivo.dispositivosBase.televisor.TelevisorLed40;
import dispositivo.dispositivosBase.ventilador.VentiladorDeTecho;
import fixture.Fixture;

public class TestSimplex extends Fixture {
	
	@Before
	public void before() {
		lio.agregarDispositivo(new ComputadoraDeEscritorio(mockPcConcreta));
		lio.agregarDispositivo(new Aire2200Frigorias(mockAireConcreto));
		lio.agregarDispositivo(new TelevisorLed40(mockTelevisorSmartConcreto));
		lio.agregarDispositivo(new LamparaDe20W(mockLampara));
		lio.agregarDispositivo(new LavarropasAutomatico5kg(mockLavarropas));
		lio.agregarDispositivo(new PlanchaAVapor(mockPlancha));
		lio.agregarDispositivo(new VentiladorDeTecho(mockVentilador));
		lio.agregarDispositivo(new MicroondasConvencional(mockMicroondas));
	}

	@Test
	public void simplex() {
		for (double elem : lio.resolucionSimplex().getPoint()) {        	
        	System.out.println(elem);        	
        }
		assertTrue(true);
	}
}