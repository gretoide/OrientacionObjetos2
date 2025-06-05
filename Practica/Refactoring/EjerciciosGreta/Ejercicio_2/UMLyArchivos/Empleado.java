package ar.edu.unlp.objetos.uno.Refactoring_ejercicio2;

/*
 * Para cada una de las siguientes situaciones, realice en forma iterativa los siguientes pasos:
 * (i) indique el mal olor,
 * (ii) indique el refactoring que lo corrige,
 * (iii) aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda).
 * Si vuelve a encontrar un mal olor, retorne al paso (i).
 * */

public class Empleado {

	private String nombre;
	private String apellido;
	private int cantidadHijos;
	private Double sueldo;
	private Double valor;
	
	/*Mal olor hay varias clases con el mismo comportamiento*/
	/*Se corregiría con una clase empleado*/
	
	/*generamos código*/
	public Empleado (String unNombre, String unApellido, Double unSueldo, Double unValor, int cantHijos) {
		this.nombre       = unNombre;
		this.apellido     = unApellido;
		this.sueldo       = unSueldo - (unSueldo * 0.13);
		this.valor        = unValor;
		this.cantidadHijos= cantHijos;
	}
	/*correjir como estaba al principio con el porcentaje para que no quede un número suelto 0.13*/

	
	public double sueldoNeto() { // template method
		return this.basico();
	}
	
	
	private double basico() { // hook 
		return this.sueldo;
	}
	public Double getSueldoBasico() {
		return (this.getSueldo() + (this.cantidadHijos * this.valor));
	}
	
	public void setSueldo(Double otroSueldo) {
		this.sueldo = otroSueldo;
	}

	public Double getSueldo() {
		return sueldo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCantidadHijos() {
		return this.cantidadHijos;
	}

	public void setCantidahijos(int cantidahijos) {
		this.cantidadHijos = cantidahijos;
	}

	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

	
}
