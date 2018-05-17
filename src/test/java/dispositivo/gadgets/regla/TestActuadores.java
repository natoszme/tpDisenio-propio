package dispositivo.gadgets.regla;

import org.junit.Assert;
import org.junit.Test;

import fixture.Fixture;

public class TestActuadores extends Fixture{
    
    @Test
    public void elActuadorQueApagaDejaElDispositivoApagado() {

		actuadorQueApaga.actuarSobre(pc);
    	
    	Assert.assertTrue(pc.estaApagado());
    }
    
    @Test
    public void elActuadorQueEnciendeDejaElDispositivoEncendido() {

		actuadorQueEnciende.actuarSobre(play4);
    	
    	Assert.assertTrue(play4.estaEncendido());
    }
}


