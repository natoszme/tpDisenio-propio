package simplex;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.Test;

import fixture.FixtureSimplex;
import tipoDispositivo.DispositivoInteligente;

public class TestOptimizacionDiferida extends FixtureSimplex{
	
	/*@Before
	public void before() {
		super.before();
		when(mockMicroondas.estaEncendido()).thenReturn(true);
		when(mockLavarropas.estaEncendido()).thenReturn(true);
	}*/
	
	@Test
    public void ElSimplexDiferidoNoApagaUnNoInteligente() {	
		JobOptimizador job = JobOptimizador.getInstance();
		job.ejecutar();
		
		verify(mockTelevisorSmartConcreto, times(0)).apagar();
    }
	
	@Test
    public void ElSimplexDiferidoApagaElTelevisorSmart() {	
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime primerDiaDelMes = LocalDateTime.of(hoy.getYear(), hoy.getMonth(), 1, 0, 0);

	    double horasDelMes =  Duration.between(primerDiaDelMes, hoy).toHours();
	    
		JobOptimizador job = JobOptimizador.getInstance();
		when(mockTv40.horasEncendidoEn(horasDelMes)).thenReturn(80000.0);
		job.ejecutar();
	
		verify(mockTv40, times(1)).apagar();
    }
	 
	@Test
	public void alOptimizarNoSePoneEnAhorroDeEnergiaElLavarropasEstandar() {
		JobOptimizador job = JobOptimizador.getInstance();
		job.ejecutar();
		
		verify(mockLavarropas, times(0)).ponerEnAhorroDeEnergia();
	}	
	
}
