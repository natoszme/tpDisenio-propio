package cliente;

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

import dispositivo.Dispositivo;

public class AdaptadorSimplexCliente {
	
	Cliente cliente;
	
	public AdaptadorSimplexCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public PointValuePair getResocionSimplex () {
		
		SimplexSolver simplexSolver = new SimplexSolver();

		LinearObjectiveFunction funcionEconomica = new LinearObjectiveFunction(this.getCoeficientesFuncionEconomica(), 0);
	 	
		PointValuePair resultado = 	simplexSolver.optimize(	funcionEconomica, 
															new LinearConstraintSet(this.generarRestricciones()), 
															GoalType.MAXIMIZE, 
															new NonNegativeConstraint(true)
															);
		return resultado;
	}
	
	private List<LinearConstraint> generarRestricciones() {
		
		List<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();
		int posicion = 0;
		
		restricciones.add(new LinearConstraint(this.getTodosLosConsumos(), Relationship.LEQ, 612));
		for(Dispositivo dispositivo : this.cliente.getDispositivos()) {
			
			restricciones.add(this.getRestriccionLineal(posicion, Relationship.LEQ, dispositivo.getRestriccionMaxima()));
			restricciones.add(this.getRestriccionLineal(posicion, Relationship.GEQ, dispositivo.getRestriccionMinima()));
			
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
	
	public double[] getTodosLosConsumos() {		
		return cliente.getDispositivos().stream().mapToDouble(dispositivo -> dispositivo.getKwPorHora()).toArray();
	}
	
	public double[] getCoeficientesSimples(int posicionValida) { 
		
		double[] listaDeCoeficientes = new double[(int) this.cliente.cantidadDispositivos()];
		int posicion = 0;
		
		for(Dispositivo dispositivo : this.cliente.getDispositivos()) {
			
			if(posicion == posicionValida)
				listaDeCoeficientes[posicion] = 1;
			else
				listaDeCoeficientes[posicion] = 0;
			
			posicion++;
		}
		
		return listaDeCoeficientes;
	}
	
	public double[] getCoeficientesFuncionEconomica() {		
		return cliente.getDispositivos().stream().mapToDouble(dispositivo -> 1).toArray();
	}
	
	// TODO recibir funciones por parametro, para no repetir logica en getTodosLosConsumos y getCoeficientesFuncionEconomica
	public double[] getDoubleArray(double fn) {
		return cliente.getDispositivos().stream().mapToDouble(dispositivo -> fn).toArray();
	}	
}
