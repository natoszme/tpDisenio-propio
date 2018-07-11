package simplex;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class TestOptimizacionDiferida extends FixtureSimplex{
	
	/*@Test
	public void */
	
	@Test
    public void ElSimplexDiferidoApagaElMicroondas() {	
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
}
