package simplex;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import dispositivo.Dispositivo;
import dispositivo.DispositivosBaseFactory;
import dispositivo.gadgets.actuador.ActuadorQueApaga;
import dispositivo.gadgets.actuador.ActuadorQuePoneEnAhorroDeEnergia;
import fixture.Fixture;
import repositorio.RepoRestriccionesUsoDispositivo;

import java.util.Arrays;

public class TestSimplex extends FixtureSimplex {

	@Test
	public void simplex() {
		//TODO reveer si nos conviene usar un singleton para no instanciar todo el tiempo
		OptimizadorUsoDispositivos optimizadorDeLio = new OptimizadorUsoDispositivos(lio);
		for (double elem : optimizadorDeLio.optimizarUsoDispositivos().getPoint()) {        	
        	//TODO no deberia haber un for y menos si no hace más que mostrar algo por consola
        	//System.out.println(elem);        	
        }
	}
	
	@Test
	public void TodasLasHorasDevueltasPorElSimplexCumplenLasRestriccionesDeCadaDispositivo() {
		OptimizadorUsoDispositivos optimizadorDeLio = new OptimizadorUsoDispositivos(lio);
		double[] horasSimplex = optimizadorDeLio.optimizarUsoDispositivos().getPoint();
		Boolean cumpleRestriccionesDeHoras = lio.getDispositivos().stream().allMatch(dispositivo -> this.cumpleConLaRestriccionParaElCliente(dispositivo, lio, horasSimplex));
		assertTrue(cumpleRestriccionesDeHoras);
	}

	public boolean cumpleConLaRestriccionParaElCliente(Dispositivo dispositivo, Cliente cliente, double[] horasSimplex) {
		return RepoRestriccionesUsoDispositivo.getInstance().dameRestriccionMaximaDe(dispositivo) >= horasSimplex[cliente.getDispositivos().indexOf(dispositivo)] 
				&& RepoRestriccionesUsoDispositivo.getInstance().dameRestriccionMinimaDe(dispositivo) <= horasSimplex[cliente.getDispositivos().indexOf(dispositivo)];
	}
	
	@Test
	public void elConsumoTotalMaxDaMenosQue612() {
		OptimizadorUsoDispositivos optimizadorDeLio = new OptimizadorUsoDispositivos(lio);
		double[] horasSimplex = optimizadorDeLio.optimizarUsoDispositivos().getPoint();
		
		//TODO esto es realmente imprescindible?
		lio.getDispositivos().stream().forEach(dispositivo -> {
			System.out.println("KwXhora:");
			System.out.println(dispositivo.getKwPorHora());
			System.out.println("Horas:");
			System.out.println(horasSimplex[lio.getDispositivos().indexOf(dispositivo)]);
		});
		
		double consumoTotal = lio.getDispositivos().stream().mapToDouble(dispositivo -> 
			dispositivo.getKwPorHora() * horasSimplex[lio.getDispositivos().indexOf(dispositivo)]
															
		).sum();
		
		System.out.println("Consumo total:");
		System.out.println(consumoTotal);
		
		assertTrue(consumoTotal <= 612);
	}
	
	@Test
	public void ElSimplexEnElPrimerDispositivoDeNicoEs360() {		
		OptimizadorUsoDispositivos optimizadorDeNico = new OptimizadorUsoDispositivos(nico);
		double[] horasSimplex = optimizadorDeNico.optimizarUsoDispositivos().getPoint();
				
		assertEquals(360, horasSimplex[0], 0);
	}
	
	@Test
	public void ElLavarropasDeNicoConsumeMasQueSuRestriccionDelSimplex() {		
		OptimizadorUsoDispositivos optimizadorDeNico = new OptimizadorUsoDispositivos(nico);
		double[] horasSimplex = optimizadorDeNico.optimizarUsoDispositivos().getPoint();
						
		assertTrue(100 > horasSimplex[1]);
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