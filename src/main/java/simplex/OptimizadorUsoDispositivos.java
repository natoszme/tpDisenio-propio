package simplex;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.util.Pair;

import cliente.Cliente;
import dispositivo.Dispositivo;
import repositorio.RepoRestriccionesUsoDispositivo;

public class OptimizadorUsoDispositivos {
	private final double MAX_CONSUMO = 612;
	private final double COEF_FN_OBJETIVO = 0;
	
	private Cliente cliente;
	
	public OptimizadorUsoDispositivos(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	public List<Pair<Dispositivo, Double>> optimizarUsoDispositivos() {
		
		SimplexSolver simplexSolver = new SimplexSolver();		
		LinearObjectiveFunction funcionEconomica = new LinearObjectiveFunction(this.getCoeficientesFuncionEconomica(), COEF_FN_OBJETIVO);
		LinearConstraintSet restricciones = new LinearConstraintSet(this.generarRestriccionesPara());
		
		PointValuePair resultadoSimplex = simplexSolver.optimize(	funcionEconomica, 
										restricciones, 
										GoalType.MAXIMIZE, 
										new NonNegativeConstraint(true)
							 		 );
		 
		 return zipDispositivosYConsumos(cliente.getDispositivos(), resultadoSimplex);
	}

	private List<Pair<Dispositivo, Double>> zipDispositivosYConsumos(List<Dispositivo> list, PointValuePair resultadoSimplex) {
		double[] array = resultadoSimplex.getPoint();
		
		return IntStream.range(0,  Math.min(list.size(), array.length)).mapToObj(
				posicionDispositivo -> new Pair<>(list.get(posicionDispositivo), array[posicionDispositivo])
		).collect(Collectors.toList());
	}
	
	private List<LinearConstraint> generarRestriccionesPara() {
		
		List<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();		
		restricciones.add(new LinearConstraint(this.getTodosLosConsumosDe(), Relationship.LEQ, MAX_CONSUMO));
		
		cliente.getDispositivos().stream().forEach(dispositivo -> {
			restricciones.add(this.getRestriccionLineal(this.cliente.getDispositivos().indexOf(dispositivo), Relationship.LEQ, RepoRestriccionesUsoDispositivo.getInstance().dameRestriccionMaximaDe(dispositivo)));
			restricciones.add(this.getRestriccionLineal(this.cliente.getDispositivos().indexOf(dispositivo), Relationship.GEQ, RepoRestriccionesUsoDispositivo.getInstance().dameRestriccionMinimaDe(dispositivo)));
		});

		return restricciones;
	}

	public LinearConstraint getRestriccionLineal(int posicion, Relationship relacion, double restriccion) {		
		return new LinearConstraint(
				this.getCoeficientesSimples(posicion), 
				relacion, 
				restriccion
		);		
	}
	
	public double[] getTodosLosConsumosDe() {
		return obtenerArrayDeDispositivosTransformadoCon((Dispositivo dispositivo) -> { return dispositivo.getKwPorHora(); });
	}
	
	public double[] getCoeficientesSimples(int posicionValida) {
		int cantDispositivos = (int) this.cliente.cantidadDispositivos();		
		return (double[]) IntStream.range(0, cantDispositivos).mapToDouble(i -> (i == posicionValida ? 1 : 0)).toArray();
	}
	
	public double[] getCoeficientesFuncionEconomica() {		
		return obtenerArrayDeDispositivosTransformadoCon((Dispositivo dispositivo) -> { return 1.0; });
	}	

	private double[] obtenerArrayDeDispositivosTransformadoCon(Function<Dispositivo, Double> lambda) {
		return cliente.getDispositivos().stream().mapToDouble(dispositivo -> lambda.apply(dispositivo)).toArray();
	}
	
	public List<Pair<Dispositivo, Double>> obtenerMaximosDeConsumoDeInteligentes(Cliente cliente) {
		
		return optimizarUsoDispositivos().stream().filter(
			par -> par.getFirst().esInteligente()
		).collect(Collectors.toList());
	} 
}