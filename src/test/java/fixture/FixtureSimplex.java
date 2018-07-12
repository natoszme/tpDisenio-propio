package fixture;

import java.time.LocalDateTime;

import org.junit.Before;

import dispositivo.Dispositivo;
import dispositivo.DispositivosBaseFactory;
import dispositivo.gadgets.actuador.ActuadorQueApaga;
import dispositivo.gadgets.actuador.ActuadorQuePoneEnAhorroDeEnergia;
import repositorio.RepoRestriccionesUsoDispositivo;
import simplex.RestriccionUsoDispositivo;

public class FixtureSimplex extends Fixture{
	@Before
	public void before() {
		Dispositivo aire2200Frigorias = DispositivosBaseFactory.getInstance().aire2200Frigorias(mockAireConcreto);
		Dispositivo aire3500Frigorias = DispositivosBaseFactory.getInstance().aire3500Frigorias(mockAireConcreto);
		Dispositivo compu = DispositivosBaseFactory.getInstance().computadoraDeEscritorio(mockPcConcreta);
		Dispositivo lavarropas = DispositivosBaseFactory.getInstance().lavarropasAutomatico5kg(mockLavarropas);
		Dispositivo microondas = DispositivosBaseFactory.getInstance().microondas(mockMicroondas);
 
		Dispositivo tv40 = DispositivosBaseFactory.getInstance().tvLed40Pulgadas(mockTv40);

		lio.agregarDispositivo(aire2200Frigorias);
		lio.agregarDispositivo(aire3500Frigorias);
		lio.agregarDispositivo(compu);
		lio.agregarDispositivo(lavarropas);
		lio.agregarDispositivo(microondas);
		
		nico.agregarDispositivo(aire3500Frigorias);
		nico.agregarDispositivo(lavarropas);
		
		aire2200Frigorias.guardarConsumoDeFecha(LocalDateTime.now(), 325);
		
		lavarropas.guardarConsumoDeFecha(LocalDateTime.now(), 100);
		
		microondas.guardarConsumoDeFecha(LocalDateTime.now(), 100);
		
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(aire2200Frigorias, 90, 360, new ActuadorQueApaga()));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(compu, 90, 360, new ActuadorQueApaga()));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(aire3500Frigorias, 90, 360, new ActuadorQueApaga()));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(lavarropas, 6, 30, new ActuadorQuePoneEnAhorroDeEnergia()));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(microondas, 6, 15, new ActuadorQueApaga()));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(televisorSmart, 50, 400, new ActuadorQueApaga()));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(tv40, 50, 400, new ActuadorQueApaga()));
		
	}
}
