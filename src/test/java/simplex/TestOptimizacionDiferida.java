package simplex;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import fixture.FixtureSimplex;
import tipoDispositivo.CalculadoraHorasMesActual;

public class TestOptimizacionDiferida extends FixtureSimplex{
	
	@Test
    public void ElSimplexDiferidoNoApagaUnNoInteligente() {	
		JobOptimizador job = JobOptimizador.getInstance();
		job.ejecutar();
		
		verify(mockTelevisorSmartConcreto, times(0)).apagar();
    }
	 
	@Test
	public void alOptimizarNoSePoneEnAhorroDeEnergiaElLavarropasEstandar() {
		JobOptimizador job = JobOptimizador.getInstance();
		job.ejecutar();
		
		verify(mockLavarropas, times(0)).ponerEnAhorroDeEnergia();
	}
	
	@Test
    public void ElSimplexDiferidoApagaElTelevisorSmart() {	    
		JobOptimizador job = JobOptimizador.getInstance();
		when(mockTv40.horasEncendidoEn(CalculadoraHorasMesActual.getInstance().horasDeMesActual())).thenReturn(80000.0);
		job.ejecutar();
	
		verify(mockTv40, times(1)).apagar();
    }
	
}
