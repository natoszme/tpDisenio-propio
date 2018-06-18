package tipoDispositivo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import dispositivo.Dispositivo;
import dispositivo.DispositivoConcreto;

public class DispositivoInteligente implements TipoDispositivo{
	private long identificadorDeFabrica;
	private DispositivoConcreto dispositivoConcreto;
	private Map<LocalDateTime, Double> consumosHastaElMomento = new LinkedHashMap<>();
	int duracionPlazoCronConsumo = 6;
	
	public DispositivoInteligente(long identificadorDeFabrica, DispositivoConcreto dispositivoConcreto) {
		this.identificadorDeFabrica = identificadorDeFabrica;
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
			return dispositivoConcreto.consumoDuranteLasUltimas(horas, identificadorDeFabrica);
		}
		//solo permite horas divisibles por duracionPlazoCronConsumo
		return dispositivoConcreto.consumoDuranteLasUltimas(duracionPlazoCronConsumo, identificadorDeFabrica) + consumoAlmacenadoEn(horas);
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
		dispositivoConcreto.apagar(identificadorDeFabrica);
	}
	
	public void encender() {
		dispositivoConcreto.encender(identificadorDeFabrica);
	}

	public void ponerEnAhorroDeEnergia() {
		dispositivoConcreto.ponerEnAhorroDeEnergia(identificadorDeFabrica);
	}
	
	public boolean estaEncendido() {
		return dispositivoConcreto.estaEncendido(identificadorDeFabrica);
	}
	
	public boolean estaApagado() {
		return dispositivoConcreto.estaApagado(identificadorDeFabrica);
	}
	
	public void convertirAInteligente(Dispositivo dispositivo, long identificadorFabrica, DispositivoConcreto dispositivoConcreto) {
		throw new NoSePuedeReConvertirAInteligenteException();
	}

	public boolean estaEnAhorroEnergia() {
		return dispositivoConcreto.estaEnAhorroEnergia(identificadorDeFabrica);
	}
}
