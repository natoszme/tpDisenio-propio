package simplex;

import static org.mockito.Mockito.times;

import static org.mockito.Mockito.verify;

import org.junit.Test;

import fixture.FixtureSimplex;

public class TestOptimizacionDiferida extends FixtureSimplex{
	
	@Test
    public void ElSimplexDiferidoNoApagaUnNoInteligente() {	
		JobOptimizador job = JobOptimizador.getInstance();
		job.ejecutar();
		
		verify(mockTelevisorSmartConcreto, times(0)).apagar();
    }
	
	@Test
    public void ElSimplexDiferidoApagaUnInteligente() {	
		JobOptimizador job = JobOptimizador.getInstance();
		job.ejecutar();
		
		verify(mockMicroondas, times(1)).apagar();
    }
	 
	@Test
	public void alOptimizarNoSePoneEnAhorroDeEnergiaElLavarropasEstandar() {
		JobOptimizador job = JobOptimizador.getInstance();
		job.ejecutar();
		
		verify(mockLavarropas, times(0)).ponerEnAhorroDeEnergia();
	}	
	
}
