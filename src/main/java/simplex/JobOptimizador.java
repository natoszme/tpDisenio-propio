package simplex;

import cliente.Cliente;
import dispositivo.Dispositivo;
import dispositivo.gadgets.actuador.Actuador;
import dispositivo.gadgets.regla.CondicionDeConsumoMayorOIgual;
import dispositivo.gadgets.regla.Regla;
import dispositivo.gadgets.regla.ReglaEstricta;
import dispositivo.gadgets.sensor.SensorHorasEncendido;

import java.util.Arrays;
import java.util.List;

import repositorio.RepoClientes;
import repositorio.RepoRestriccionesUsoDispositivo;

public class JobOptimizador {
	
	public static JobOptimizador instancia;
	public static JobOptimizador getInstance() {
		if (instancia == null) {
			instancia = new JobOptimizador();
		}
		return instancia;
	}
	
	public void ejecutar() {
		RepoClientes.getInstance().obtenerAhorradores().forEach(cliente -> this.obtenerMaximosYGenerarReglas(cliente));
	}

	public void obtenerMaximosYGenerarReglas(Cliente cliente) {
		new OptimizadorUsoDispositivos(cliente).obtenerMaximosDeConsumoDeInteligentes().forEach(
			par -> this.generarYAplicarRegla(par.getFirst(), par.getSecond())
		);
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