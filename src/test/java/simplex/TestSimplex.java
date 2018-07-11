package simplex;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import dispositivo.Dispositivo;
import dispositivo.DispositivosBaseFactory;
import dispositivo.gadgets.actuador.ActuadorQueApaga;
import dispositivo.gadgets.actuador.ActuadorQuePoneEnAhorroDeEnergia;
import fixture.Fixture;
import java.util.Arrays;

public class TestSimplex extends Fixture {
	
	@Before
	public void before() {
		Dispositivo aire2200Frigorias = DispositivosBaseFactory.getInstance().aire2200Frigorias(mockAireConcreto);
		Dispositivo aire3500Frigorias = DispositivosBaseFactory.getInstance().aire3500Frigorias(mockAireConcreto);
		Dispositivo compu = DispositivosBaseFactory.getInstance().computadoraDeEscritorio(mockPcConcreta);
		Dispositivo lavarropas = DispositivosBaseFactory.getInstance().lavarropasAutomatico5kg(mockLavarropas);
		Dispositivo microondas = DispositivosBaseFactory.getInstance().microondas(mockMicroondas);
		lio.agregarDispositivo(aire2200Frigorias);
		lio.agregarDispositivo(aire3500Frigorias);
		lio.agregarDispositivo(compu);
		lio.agregarDispositivo(lavarropas);
		lio.agregarDispositivo(microondas);
		
		nico.agregarDispositivo(aire3500Frigorias);
		nico.agregarDispositivo(lavarropas);
		
		//TODO reveer esto!
		aire2200Frigorias.encender();
		aire2200Frigorias.guardarConsumoDeFecha(LocalDateTime.now(), 325);
		
		lavarropas.encender();
		lavarropas.guardarConsumoDeFecha(LocalDateTime.now(), 100);
		
		microondas.encender();
		microondas.guardarConsumoDeFecha(LocalDateTime.now(), 100);
		
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(aire2200Frigorias, 90, 360, new ActuadorQueApaga()));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(compu, 90, 360, new ActuadorQueApaga()));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(aire3500Frigorias, 90, 360, new ActuadorQueApaga()));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(lavarropas, 6, 30, new ActuadorQuePoneEnAhorroDeEnergia()));
		RepoRestriccionesUsoDispositivo.getInstance().agregarEntidad(new RestriccionUsoDispositivo(microondas, 6, 15, new ActuadorQueApaga()));
	}

	@Test
	public void simplex() {
		//TODO reveer si nos conviene usar un singleton para no instanciar todo el tiempo
		OptimizadorUsoDispositivos optimizadorDeLio = new OptimizadorUsoDispositivos(lio);
		for (double elem : optimizadorDeLio.optimizarUsoDispositivos().getPoint()) {        	
        	System.out.println(elem);        	
        }
	}
	

	
	@Test
	public void TodasLasHorasDevueltasPorElSimplexCumplenLasRestriccionesDeCadaDispositivo() {
		OptimizadorUsoDispositivos optimizadorDeLio = new OptimizadorUsoDispositivos(lio);
		double[] horasSimplex = optimizadorDeLio.optimizarUsoDispositivos().getPoint();
		Boolean cumpleRestriccionesDeHoras = lio.getDispositivos().stream().allMatch(dispositivo->
				(	
					RepoRestriccionesUsoDispositivo.getInstance().dameRestriccionMaximaDe(dispositivo) >= horasSimplex[lio.getDispositivos().indexOf(dispositivo)] &&
					RepoRestriccionesUsoDispositivo.getInstance().dameRestriccionMinimaDe(dispositivo) <= horasSimplex[lio.getDispositivos().indexOf(dispositivo)]		
				) 
			);
									
		assertTrue(cumpleRestriccionesDeHoras);
	}
	
	@Test
	public void elConsumoTotalMaxDaMenosQue612() {
		OptimizadorUsoDispositivos optimizadorDeLio = new OptimizadorUsoDispositivos(lio);
		double[] horasSimplex = optimizadorDeLio.optimizarUsoDispositivos().getPoint();
		double consumoTotal = lio.getDispositivos().stream().mapToDouble(dispositivo -> 
			dispositivo.getKwPorHora() * horasSimplex[lio.getDispositivos().indexOf(dispositivo)]
															
		).sum();
		
		assertTrue(consumoTotal <= 612);
	}
	
	@Test
	public void ElSimplexEnElPrimerDispositivoDeNicoEs360() {
		
		OptimizadorUsoDispositivos optimizadorDeNico = new OptimizadorUsoDispositivos(nico);
		double[] horasSimplex = optimizadorDeNico.optimizarUsoDispositivos().getPoint();
				
		assertEquals(360, horasSimplex[0],0);
	}
	
	@Test
	public void ElLavarropasDeNicoConsumeMasQueSuRestriccionDelSimplex() {
		
		OptimizadorUsoDispositivos optimizadorDeNico = new OptimizadorUsoDispositivos(nico);
		double[] horasSimplex = optimizadorDeNico.optimizarUsoDispositivos().getPoint();
						
		assertTrue(100 > horasSimplex[1]);
	}
		
	@Test
    public void ElSimplexDiferidoDebeApagarElMicroondas() {	
		JobOptimizador job = JobOptimizador.getInstance();
		job.ejecutar();
		
		verify(mockMicroondas, times(1)).apagar();
    }
	 
	@Test
	public void alOptimizarSePoneEnAhorroDeEnergiaElLavarropas() {
		JobOptimizador job = JobOptimizador.getInstance();
		job.ejecutar();
		
		verify(mockLavarropas, times(1)).ponerEnAhorroDeEnergia();
	}
	
	@Test
	public void LosCoeficientesDeLaFuncionEconomicaSonTodos1() {
		OptimizadorUsoDispositivos optimizadorDeLio = new OptimizadorUsoDispositivos(lio);
		assertTrue (Arrays.stream(optimizadorDeLio.getCoeficientesFuncionEconomica()).allMatch(coeficiente -> (coeficiente == 1)));
	}
	
	@Test
	public void EnLaFuncionEconomicaHayTantosCoeficientesComoDispositivosTieneElCliente() {
		OptimizadorUsoDispositivos optimizadorDeLio = new OptimizadorUsoDispositivos(lio);
		assertEquals(lio.cantidadDispositivos(), optimizadorDeLio.getCoeficientesFuncionEconomica().length, 0);
	}	
}