package dispositivo.gadgets.regla;
import org.junit.Before;
import org.junit.Test;

import fixture.Fixture;
import dispositivo.gadgets.actuador.Actuador;
import dispositivo.gadgets.actuador.ActuadorQueApaga;
import dispositivo.gadgets.actuador.ActuadorQueEnciende;
import dispositivo.gadgets.regla.NoSePuedeUsarReglaSobreDispositivoNoInteligenteException;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class TestRegla extends Fixture {
	
	List<Actuador> actuadores = new ArrayList<>();
	
	@Before
	public void initialize() {
    	actuadorQueApagaSmartTv = new ActuadorQueApaga(televisorSmart);
    	actuadorQueEnciendeSmartTv = new ActuadorQueEnciende(televisorSmart);
    	
    	when(mockCondicionSobreSensorQueCumple.seCumpleCondicion()).thenReturn(true);
    	when(mockCondicionSobreSensorQueNoCumple.seCumpleCondicion()).thenReturn(false);
    	
    	when(mockCondicionSobreSensorQueCumple.getDispositivo()).thenReturn(televisorSmart);
    	when(mockCondicionSobreSensorQueNoCumple.getDispositivo()).thenReturn(televisorSmart);
	}

    @Test(expected = NoSePuedeUsarReglaSobreDispositivoNoInteligenteException.class)
    public void alCrearReglaConDispositivoEstandarTiraExcepcion() {
    	reglaEstricta = new ReglaEstricta(null, condicionesSobreSensorQueCumplen, equipoMusica);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueCumpleSeEnviaSenialApagado() {
    	actuadores.add(actuadorQueApagaSmartTv);
		reglaEstricta = new ReglaEstricta(actuadores, condicionesSobreSensorQueCumplen, televisorSmart);
    	reglaEstricta.aplicarSiCumpleCriterio();
    	
    	verify(mockTelevisorSmartConcreto, times(1)).apagar(123456);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueCumpleSeEnviaSenialEncendido() {
    	actuadores.add(actuadorQueEnciendeSmartTv);
    	reglaEstricta = new ReglaEstricta(actuadores, condicionesSobreSensorQueCumplen, televisorSmart);
    	reglaEstricta.aplicarSiCumpleCriterio();
    	
    	verify(mockTelevisorSmartConcreto, times(1)).encender(123456);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueNoCumpleNoSeEnviaSenialDEncendido() {
    	actuadores.add(actuadorQueApagaSmartTv);
		reglaPermisiva = new ReglaEstricta(actuadores, condicionesSobreSensorQueNoCumplen, televisorSmart);
    	reglaPermisiva.aplicarSiCumpleCriterio();
    	
    	verify(mockTelevisorSmartConcreto, times(0)).apagar(123456);
    }
}