package categoria;

import javax.persistence.Column;
import javax.persistence.Entity;

import db.DatosBasicos;

@Entity
public class Categoria extends DatosBasicos {
	
	@Column(nullable = false, unique = true)
	private String nombre;
	
	private double consumoMinimo;
	private double consumoMaximo;
	private double cargoFijo;
	private double cargoVariable;
	
	public Categoria() {}
	public Categoria(String nombre, double consumoMinimo, double consumoMaximo, double cargoFijo, double cargoVariable) {
		this.nombre = nombre;
		this.consumoMinimo = consumoMinimo;
		this.consumoMaximo = consumoMaximo;
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getConsumoMinimo() {
		return this.consumoMinimo;
	}
	
	public double getConsumoMaximo() {
		return this.consumoMaximo;
	}
	
	public double getCargoFijo() {
		return this.cargoFijo;
	}
	
	public double getCargoVariable() {
		return this.cargoVariable;
	}
	
	public boolean meCorrespondeElConsumo(double consumo) {
		return consumo > consumoMinimo &&  consumo <= consumoMaximo;
	}
}
