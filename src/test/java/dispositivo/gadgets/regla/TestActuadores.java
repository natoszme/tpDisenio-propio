package dispositivo.gadgets.regla;

import org.junit.Assert;
import org.junit.Test;

import fixture.Fixture;
import dispositivo.gadgets.actuador.ActuadorQueApaga;
import dispositivo.gadgets.actuador.ActuadorQueEnciende;

public class TestActuadores extends Fixture{
    
    @Test
    public void elActuadorQueApagaDejaElDispositivoApagado() {

		actuador = new ActuadorQueApaga();
		actuador.actuarSobre(pc);
    	
    	Assert.assertTrue(pc.estaApagado());
    }
    
    @Test
    public void elActuadorQueEnciendeDejaElDispositivoEncendido() {

		actuador = new ActuadorQueEnciende();
		actuador.actuarSobre(play4);
    	
    	Assert.assertTrue(play4.estaEncendido());
    }
}


