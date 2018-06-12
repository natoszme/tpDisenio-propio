package dispositivo.gadgets.regla;
import org.junit.Before;
import org.junit.Test;

import fixture.Fixture;
import tipoDispositivo.DispositivoInteligente;
import dispositivo.Dispositivo;
import dispositivo.gadgets.actuador.ActuadorQueApaga;
import dispositivo.gadgets.actuador.ActuadorQueEnciende;
import dispositivo.gadgets.regla.NoSePuedeUsarGadgetSobreDispositivoNoInteligenteException;

import static org.mockito.Mockito.*;

public class TestRegla extends Fixture {
	
	@Before
	public void initialize() {
    	televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockTelevisorSmartConcreto));
    	actuadorQueApagaSmartTv = new ActuadorQueApaga(televisorSmart);
    	actuadorQueEnciendeSmartTv = new ActuadorQueEnciende(televisorSmart);
    	
    	when(mockCondicionSobreSensorQueCumple.seCumpleCondicion()).thenReturn(true);
    	when(mockCondicionSobreSensorQueNoCumple.seCumpleCondicion()).thenReturn(false);
	}

    @Test(expected = NoSePuedeUsarGadgetSobreDispositivoNoInteligenteException.class)
    public void alCrearReglaConDispositivoEstandarTiraExcepcion() {
    	reglaEstricta = new ReglaEstricta(null, condicionesSobreSensorQueCumplen, equipoMusica);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueCumpleSeEnviaSenialApagado() {		
		reglaEstricta = new ReglaEstricta(actuadorQueApagaSmartTv, condicionesSobreSensorQueCumplen, televisorSmart);
    	reglaEstricta.aplicarSiCumpleCriterio();
    	
    	verify(mockTelevisorSmartConcreto, times(1)).apagar(123456);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueCumpleSeEnviaSenialEncendido() {		
    	reglaEstricta = new ReglaEstricta(actuadorQueEnciendeSmartTv, condicionesSobreSensorQueCumplen, televisorSmart);
    	reglaEstricta.aplicarSiCumpleCriterio();
    	
    	verify(mockTelevisorSmartConcreto, times(1)).encender(123456);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueNoCumpleNoSeEnviaSenialDEncendido() {		
		reglaPermisiva = new ReglaEstricta(actuadorQueApagaSmartTv, condicionesSobreSensorQueNoCumplen, televisorSmart);
    	reglaPermisiva.aplicarSiCumpleCriterio();
    	
    	verify(mockTelevisorSmartConcreto, times(0)).apagar(123456);
    }
}