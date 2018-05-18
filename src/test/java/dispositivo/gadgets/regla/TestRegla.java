package dispositivo.gadgets.regla;
import org.junit.Before;
import org.junit.Test;

import fixture.Fixture;
import tipoDispositivo.DispositivoInteligente;
import dispositivo.Dispositivo;
import dispositivo.gadgets.regla.NoSePuedeEvaluarReglaADispositivoNoInteligenteException;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class TestRegla extends Fixture {
	
	@Before
	public void initialize() {
		//TODO estos metodos estan aca porque se llaman a los metodos posta (segun el fixture)
		mockReglaCumplida.setCondiciones(new ArrayList<>());
		mockReglaNoCumplida.setCondiciones(new ArrayList<>());
    	when(mockReglaCumplida.seCumplenTodas()).thenReturn(true);
    	when(mockReglaNoCumplida.seCumpleAlguna()).thenReturn(false);
    	televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(123456, mockFabricante));
	}

    @Test(expected = NoSePuedeEvaluarReglaADispositivoNoInteligenteException.class)
    public void alEvaluarUnDispositivoEstandarTiraExcepcion() {
    	mockReglaCumplida.evaluarTodasSobre(televisor);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueCumpleSeEnviaSenialApagado() {		
		mockReglaCumplida.setActuador(actuadorQueApaga);
    	mockReglaCumplida.evaluarTodasSobre(televisorSmart);
    	
    	verify(mockFabricante, times(1)).apagar(123456);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueCumpleSeEnviaSenialEncendido() {		
		mockReglaCumplida.setActuador(actuadorQueEnciende);
    	mockReglaCumplida.evaluarTodasSobre(televisorSmart);
    	
    	verify(mockFabricante, times(1)).encender(123456);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueNoCumple_NoSeEnviaSenialDEncendido() {		
		mockReglaNoCumplida.setActuador(actuadorQueEnciende);
    	mockReglaNoCumplida.evaluarAlgunaSobre(televisorSmart);
    	
    	verify(mockFabricante, times(0)).encender(123456);
    }
    
    @Test
    public void alEvaluarUnInteligenteQueNoCumple_NoSeEnviaNingunaSenial() {		
		mockReglaNoCumplida.setActuador(actuadorQueApaga);
    	mockReglaNoCumplida.evaluarAlgunaSobre(televisorSmart);
    	
    	verify(mockFabricante, times(0)).apagar(123456);
    }
}