package dispositivo.gadgets.actuador;

import static org.mockito.Mockito.times; 
import static org.mockito.Mockito.verify;

import org.junit.Test;

import fixture.Fixture;

public class TestActuadores extends Fixture {
    
    @Test
    public void elActuadorQueApagaHaceQueSeEnvieLaSeñalDeApagado() {
		actuadorQueApagaPc.actuar();
		verify(mockPcConcreta, times(1)).apagar();
    }
    
    @Test
    public void elActuadorQueEnciendeUnAireHaceQueSeEnvieLaSeñalDeApagado() {
		actuadorQueEnciendeAire.actuar();    	
		verify(mockAireConcreto, times(1)).encender();
    }   
}


