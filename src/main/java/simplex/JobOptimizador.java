package simplex;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.math3.util.Pair;

import cliente.Cliente;
import dispositivo.Dispositivo;
import dispositivo.gadgets.actuador.Actuador;
import dispositivo.gadgets.regla.CondicionDeConsumoMayorOIgual;
import dispositivo.gadgets.regla.Regla;
import dispositivo.gadgets.regla.ReglaEstricta;
import dispositivo.gadgets.sensor.SensorHorasEncendido;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import repositorio.RepoClientes;

public class JobOptimizador {
	
	public static JobOptimizador instancia;
	public static JobOptimizador getInstance() {
		if (instancia == null) {
			instancia = new JobOptimizador();
		}
		return instancia;
	}
	
	public void ejecutar() {
		RepoClientes.getInstance().obtenerAhorradores().forEach(cliente -> {			
			this.zipDispositivosInteligentesYConsumos(cliente).forEach(
				(Consumer<? super Pair<Dispositivo, Double>>) par -> this.generarYAplicarRegla(par.getFirst(), par.getSecond())
			);			
		});
	}
	
	private List<Pair<Dispositivo, Double>> zipDispositivosInteligentesYConsumos(Cliente cliente) {
		double[] horasDeConsumoMaximas = new OptimizadorUsoDispositivos(cliente).optimizarUsoDispositivos().getPoint();
		
		return this.zipDispositivosYConsumos(cliente.getDispositivos(), horasDeConsumoMaximas).stream().filter(
			par -> par.getFirst().esInteligente()
		).collect(Collectors.toList());
	} 

	private List<Pair<Dispositivo, Double>> zipDispositivosYConsumos(List<Dispositivo> list, double[] array) {
		return IntStream.range(0,  Math.min(list.size(), array.length)).mapToObj(
				i -> new Pair<>(list.get(i), array[i])
		).collect(Collectors.toList());
	}
	
	private void generarYAplicarRegla(Dispositivo dispositivo, double consumoMaximo) {
		CondicionDeConsumoMayorOIgual condicion = new CondicionDeConsumoMayorOIgual(consumoMaximo, new SensorHorasEncendido(dispositivo));
		Regla regla = new ReglaEstricta(obtenerActuadorDe(dispositivo), Arrays.asList(condicion), dispositivo);
		regla.aplicarSiCumpleCriterio();
	}
	
	private List<Actuador> obtenerActuadorDe(Dispositivo dispositivo) {
		return Arrays.asList(RepoRestriccionesUsoDispositivo.getInstance().dameAccionDe(dispositivo));
	}
	
	
}