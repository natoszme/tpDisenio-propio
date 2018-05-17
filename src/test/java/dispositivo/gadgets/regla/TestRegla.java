package dispositivo.gadgets.regla;
import org.junit.Before;
import org.junit.Test;

import fixture.Fixture;
import tipoDispositivo.DispositivoInteligente;
import dispositivo.Dispositivo;
import dispositivo.gadgets.regla.NoSePuedeEvaluarReglaADispositivoNoInteligenteException;

import static org.mockito.Mockito.*;

public class TestRegla  extends Fixture {
	
	@Before
	public void initialize() {
    	when(mockRegla.seCumpleCondicion()).thenReturn(true);
    	televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockFabricante));
	}

    @Test(expected = NoSePuedeEvaluarReglaADispositivoNoInteligenteException.class)
    public void alEvaluarUnDispositivoEstandarTiraExcepcion() {
    	mockRegla.evaluarPara(televisor);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueCumpleSeEnviaSenialApagado() {		
		mockRegla.setActuador(actuadorQueApaga);
    	mockRegla.evaluarPara(televisorSmart);
    	
    	verify(mockFabricante, times(1)).apagar(123456);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueCumpleSeEnviaSenialEncendido() {		
		mockRegla.setActuador(actuadorQueEnciende);
    	mockRegla.evaluarPara(televisorSmart);
    	
    	verify(mockFabricante, times(1)).encender(123456);
    }
}