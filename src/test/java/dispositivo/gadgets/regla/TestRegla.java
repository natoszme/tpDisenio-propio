package dispositivo.gadgets.regla;

import org.junit.Assert;
import org.junit.Test;

import fixture.Fixture;
import tipoDispositivo.DispositivoInteligente;
import dispositivo.Dispositivo;
import dispositivo.gadgets.actuador.ActuadorQueApaga;
import dispositivo.gadgets.regla.NoSePuedeEvaluarReglaADispositivoNoInteligenteException;

import static org.mockito.Mockito.*;

public class TestRegla  extends Fixture {

    @Test(expected = NoSePuedeEvaluarReglaADispositivoNoInteligenteException.class)
    public void alEvaluarUnDispositivoEstandarTiraExcepcion() {
    	mockRegla.evaluarPara(televisor);
    }
    
    @Test
    public void unDispositivoInteligenteSeApagaAlEvaluarloConUnActuadorQueApaga() {

    	when(mockRegla.seCumpleCondicion()).thenReturn(true);

		televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockFabricante));
		actuador = new ActuadorQueApaga();
		
    	mockRegla.setActuador(actuador);
    	mockRegla.evaluarPara(televisorSmart);
    	
    	Assert.assertTrue(televisorSmart.estaApagado());
    }
}
