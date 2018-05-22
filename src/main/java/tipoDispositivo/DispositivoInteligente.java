package tipoDispositivo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import dispositivo.Dispositivo;
import fabricante.Fabricante;

public class DispositivoInteligente implements TipoDispositivo{
	private long identificadorDeFabrica;
	private Fabricante fabricante;
	private Map<LocalDateTime, Double> consumosHastaElMomento = new LinkedHashMap<>();
	int duracionPlazoCronConsumo = 6;
	
	public DispositivoInteligente(long identificadorDeFabrica, Fabricante fabricante) {
		this.identificadorDeFabrica = identificadorDeFabrica;
		this.fabricante = fabricante;
	}
	
	public boolean esInteligente() {
		return true;
	}
	
	public double puntosPorRegistrar() {
		return 15;
	}
	
	public double consumoEnLasUltimas(int horas) {
		if (horas <= duracionPlazoCronConsumo) {
			return fabricante.consumoDuranteLasUltimas(horas, identificadorDeFabrica);
		}
		//solo permite horas divisibles por duracionPlazoCronConsumo
		return fabricante.consumoDuranteLasUltimas(duracionPlazoCronConsumo, identificadorDeFabrica) + consumoAlmacenadoEn(horas);
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
		fabricante.apagar(identificadorDeFabrica);
	}
	
	public void encender() {
		fabricante.encender(identificadorDeFabrica);
	}

	public void ponerEnAhorroDeEnergia() {
		fabricante.ponerEnAhorroDeEnergia(identificadorDeFabrica);
	}
	
	public boolean estaEncendido() {
		return fabricante.estaEncendido(identificadorDeFabrica);
	}
	
	public boolean estaApagado() {
		return fabricante.estaApagado(identificadorDeFabrica);
	}
	
	public void convertirAInteligente(Dispositivo dispositivo, long identificadorFabrica, Fabricante fabricante) {
		throw new NoSePuedeReConvertirAInteligenteException();
	}

	public boolean estaEnAhorroEnergia() {
		return fabricante.estaEnAhorroEnergia(identificadorDeFabrica);
	}
}
