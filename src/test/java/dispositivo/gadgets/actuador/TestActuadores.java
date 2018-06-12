package dispositivo.gadgets.actuador;

import static org.mockito.Mockito.times; 
import static org.mockito.Mockito.verify;

import org.junit.Test;

import fixture.Fixture;

public class TestActuadores extends Fixture {
    
    @Test
    public void elActuadorQueApagaHaceQueSeEnvieLaSeñalDeApagado() {
		actuadorQueApagaPc.actuar();
		verify(mockPcConcreta, times(1)).apagar(101010);
    }
    
    @Test
    public void elActuadorQueEnciendeUnAireHaceQueSeEnvieLaSeñalDeApagado() {
		actuadorQueEnciendeAire.actuar();    	
		verify(mockAireConcreto, times(1)).encender(210154);
    }   
}


