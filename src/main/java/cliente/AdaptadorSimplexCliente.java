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
		
		restricciones.add(new LinearConstraint(cliente.getTodosLosConsumos(), Relationship.LEQ, 612));
		for(Dispositivo dispositivo : this.cliente.getDispositivos()) {
			
			restricciones.add(	new LinearConstraint(	this.getCoeficientesSimples(posicion), 
														Relationship.LEQ, 
														dispositivo.getRestriccionMaxima()
													)
							);
			
			restricciones.add(	new LinearConstraint(	this.getCoeficientesSimples(posicion), 
														Relationship.GEQ, 
														dispositivo.getRestriccionMinima()
													)
							);
			
			posicion++;
		}
			
		return restricciones;
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
		
		double[] listaDeCoeficientes = new double[(int) this.cliente.cantidadDispositivos()];
		int posicion = 0;
		
		for(Dispositivo dispositivo : this.cliente.getDispositivos()) {
			listaDeCoeficientes[posicion] = 1;
			posicion++;
		}
		
		return listaDeCoeficientes;
	}
	
}
