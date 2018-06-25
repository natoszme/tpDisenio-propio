package simplex;

import java.util.ArrayList;
import java.util.List;

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
	
	private Cliente cliente;
	public OptimizadorUsoDispositivos(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	public PointValuePair optimizarUsoDispositivos() {
		
		SimplexSolver simplexSolver = new SimplexSolver();		
		LinearObjectiveFunction funcionEconomica = new LinearObjectiveFunction(this.getCoeficientesFuncionEconomica(), 0);
	 	
		return simplexSolver.optimize(	funcionEconomica, 
										new LinearConstraintSet(this.generarRestriccionesPara()), 
										GoalType.MAXIMIZE, 
										new NonNegativeConstraint(true)
							 		 );
	}
	
	private List<LinearConstraint> generarRestriccionesPara() {
		
		List<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();
		int posicion = 0;
		
		restricciones.add(new LinearConstraint(this.getTodosLosConsumosDe(), Relationship.LEQ, MAX_CONSUMO));
		for(Dispositivo dispositivo : cliente.getDispositivos()) {
			
			restricciones.add(this.getRestriccionLineal(posicion, Relationship.LEQ, RepoRestriccionesUsoDispositivo.getInstance().dameRestriccionMaximaDe(dispositivo)));
			restricciones.add(this.getRestriccionLineal(posicion, Relationship.GEQ, RepoRestriccionesUsoDispositivo.getInstance().dameRestriccionMinimaDe(dispositivo)));
			
			posicion++;
		}
			
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
		
		//TODO habria que terminar de adaptarlo
		/*List<Double> listaDeCoeficientes = new ArrayList<>();
		cliente.getDispositivos().forEach(dispositivo -> setearCoeficientes(listaDeCoeficientes, posicionValida));
		return listaDeCoeficientes.toArray();*/
		
		double[] listaDeCoeficientes = new double[(int) this.cliente.cantidadDispositivos()];
		int posicion = 0;
		
		for(Dispositivo dispositivo : this.cliente.getDispositivos()) {
			listaDeCoeficientes[posicion] = (posicion == posicionValida ? 1 : 0);			
			posicion++;
		}
		
		return listaDeCoeficientes;
	}
	
	//se usaria para lo de arriba
	/*private void setearCoeficientes(List<Double> listaDeCoeficientes, int posicionValida) {
		listaDeCoeficientes.add((double) (listaDeCoeficientes.size() - 1 == posicionValida ? 1 : 0));
	}*/
	
	public double[] getCoeficientesFuncionEconomica() {		
		return cliente.getDispositivos().stream().mapToDouble(dispositivo -> 1).toArray();
	}
	
	// TODO recibir funciones por parametro, para no repetir logica en getTodosLosConsumos y getCoeficientesFuncionEconomica
	public double[] getDoubleArray(double fn) {
		return cliente.getDispositivos().stream().mapToDouble(dispositivo -> fn).toArray();
	}	
}