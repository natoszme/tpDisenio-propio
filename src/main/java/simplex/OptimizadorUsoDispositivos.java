package simplex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import cliente.Cliente;
import dispositivo.Dispositivo;

public class OptimizadorUsoDispositivos {
	final double MAX_CONSUMO = 612;
	final double COEF_FN_OBJETIVO = 1;
	
	private Cliente cliente;
	public OptimizadorUsoDispositivos(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	public PointValuePair optimizarUsoDispositivos() {
		
		SimplexSolver simplexSolver = new SimplexSolver();		
		LinearObjectiveFunction funcionEconomica = new LinearObjectiveFunction(this.getCoeficientesFuncionEconomica(), COEF_FN_OBJETIVO);
	 	
		return simplexSolver.optimize(	funcionEconomica, 
										new LinearConstraintSet(this.generarRestriccionesPara()), 
										GoalType.MAXIMIZE, 
										new NonNegativeConstraint(true)
							 		 );
	}
	
	private List<LinearConstraint> generarRestriccionesPara() {
		
		List<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();		
		restricciones.add(new LinearConstraint(this.getTodosLosConsumosDe(), Relationship.LEQ, MAX_CONSUMO));
		
		cliente.getDispositivos().stream().forEach(dispositivo -> {
			restricciones.add(this.getRestriccionLineal(restricciones.size() - 1, Relationship.LEQ, RepoRestriccionesUsoDispositivo.getInstance().dameRestriccionMaximaDe(dispositivo)));
			restricciones.add(this.getRestriccionLineal(restricciones.size() - 1, Relationship.GEQ, RepoRestriccionesUsoDispositivo.getInstance().dameRestriccionMinimaDe(dispositivo)));
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
		return cliente.getDispositivos().stream().mapToDouble(dispositivo -> dispositivo.getKwPorHora()).toArray();
	}
	
	public double[] getCoeficientesSimples(int posicionValida) {
		int cantDispositivos = (int) this.cliente.cantidadDispositivos();		
		return (double[]) IntStream.range(0, cantDispositivos).mapToDouble(i -> (i == posicionValida ? 1 : 0)).toArray();
	}
	
	public double[] getCoeficientesFuncionEconomica() {		
		return cliente.getDispositivos().stream().mapToDouble(dispositivo -> 1).toArray();
	}
	
	// TODO recibir funciones por parametro, para no repetir logica en getTodosLosConsumos y getCoeficientesFuncionEconomica
	public double[] getDoubleArray(double fn) {
		return cliente.getDispositivos().stream().mapToDouble(dispositivo -> fn).toArray();
	}	
}