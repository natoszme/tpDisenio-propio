package tipoDispositivo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;

public class DispositivoInteligente implements TipoDispositivo{
	private long identificadorDeFabrica;
	private DispositivoConcreto dispositivoReal;
	private Map<LocalDateTime, Double> consumosHastaElMomento = new LinkedHashMap<>();
	int duracionPlazoCronConsumo = 6;
	
	public DispositivoInteligente(long identificadorDeFabrica, DispositivoConcreto fabricante) {
		this.identificadorDeFabrica = identificadorDeFabrica;
		this.dispositivoReal = fabricante;
	}
	
	public boolean esInteligente() {
		return true;
	}
	
	public double puntosPorRegistrar() {
		return 15;
	}
	
	public double consumoEnLasUltimas(int horas) {		
		if (horas <= duracionPlazoCronConsumo) {
			return dispositivoReal.consumoDuranteLasUltimas(horas, identificadorDeFabrica);
		}
		//solo permite horas divisibles por duracionPlazoCronConsumo
		return dispositivoReal.consumoDuranteLasUltimas(duracionPlazoCronConsumo, identificadorDeFabrica) + consumoAlmacenadoEn(horas);
	}

	public double consumoAlmacenadoEn(int horas) {
		return consumosHastaElMomento.entrySet().stream().
				filter(consumoFechado -> correspondeAPlazo(consumoFechado.getKey(), horas - duracionPlazoCronConsumo)).
				mapToDouble(consumoFechado -> consumoFechado.getValue()).
				sum();
	}

	//ojo que podria calcular demas!
	private boolean correspondeAPlazo(LocalDateTime dateTimeAEvaluar, int horasABuscar) {
		return Duration.between(dateTimeAEvaluar, LocalDateTime.now()).toHours() <= horasABuscar;
	}

	public void guardarConsumoDeFecha(LocalDateTime fecha, double consumo) {
		consumosHastaElMomento.put(fecha, consumo);
	}
	
	public void apagar() {
		dispositivoReal.apagar(identificadorDeFabrica);
	}
	
	public void encender() {
		dispositivoReal.encender(identificadorDeFabrica);
	}

	public void ponerEnAhorroDeEnergia() {
		dispositivoReal.ponerEnAhorroDeEnergia(identificadorDeFabrica);
	}
	
	public boolean estaEncendido() {
		return dispositivoReal.estaEncendido(identificadorDeFabrica);
	}
	
	public boolean estaApagado() {
		return dispositivoReal.estaApagado(identificadorDeFabrica);
	}
	
	public void convertirAInteligente(Dispositivo dispositivo, long identificadorFabrica, DispositivoConcreto fabricante) {
		throw new NoSePuedeReConvertirAInteligenteException();
	}

	public boolean estaEnAhorroEnergia() {
		return dispositivoReal.estaEnAhorroEnergia(identificadorDeFabrica);
	}
}
