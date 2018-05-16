package regla;

import org.junit.Test;

import fixture.Fixture;
import regla.NoSePuedeEvaluarReglaADispositivoNoInteligenteException;

public class TestRegla  extends Fixture {

    @Test(expected = NoSePuedeEvaluarReglaADispositivoNoInteligenteException.class)
    public void alEvaluarUnDispositivoEstandarTiraExcepcion() {
    	mockRegla.evaluarPara(televisor);
    }
}
