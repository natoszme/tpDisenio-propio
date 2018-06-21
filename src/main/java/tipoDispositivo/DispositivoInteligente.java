package tipoDispositivo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;

public class DispositivoInteligente implements TipoDispositivo{
	private DispositivoConcreto dispositivoConcreto;
	private Map<LocalDateTime, Double> consumosHastaElMomento = new LinkedHashMap<>();
	int duracionPlazoCronConsumo = 6;
	
	public DispositivoInteligente(DispositivoConcreto dispositivoConcreto) {
		this.dispositivoConcreto = dispositivoConcreto;
	}
	
	public boolean esInteligente() {
		return true;
	}
	
	public double puntosPorRegistrar() {
		return 15;
	}
	
	public double consumoEnLasUltimas(int horas, Dispositivo dispositivo) {		
		if (horas <= duracionPlazoCronConsumo) {
			return dispositivoConcreto.consumoDuranteLasUltimas(horas);
		}
		//solo permite horas divisibles por duracionPlazoCronConsumo
		return dispositivoConcreto.consumoDuranteLasUltimas(duracionPlazoCronConsumo) + consumoAlmacenadoEn(horas);
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
		dispositivoConcreto.apagar();
	}
	
	public void encender() {
		dispositivoConcreto.encender();
	}

	public void ponerEnAhorroDeEnergia() {
		dispositivoConcreto.ponerEnAhorroDeEnergia();
	}
	
	public boolean estaEncendido() {
		return dispositivoConcreto.estaEncendido();
	}
	
	public boolean estaApagado() {
		return dispositivoConcreto.estaApagado();
	}
	
	public void convertirAInteligente(Dispositivo dispositivo, DispositivoConcreto dispositivoConcreto) {
		throw new NoSePuedeReConvertirAInteligenteException();
	}

	public boolean estaEnAhorroEnergia() {
		return dispositivoConcreto.estaEnAhorroEnergia();
	}
}
