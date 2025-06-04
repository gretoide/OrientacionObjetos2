private Object personal;

public void imprimirValores() {
	int totalEdades = 0;
	double promedioEdades = 0;
	double totalSalarios = 0;
	
	for (Empleado empleado : personal) {
		totalEdades = totalEdades + empleado.getEdad();
		totalSalarios = totalSalarios + empleado.getSalario();
	}
	promedioEdades = totalEdades / personal.size();
		
	String message = String.format("El promedio de las edades es %s y el total de salarios es %s", promedioEdades, totalSalarios);
	
	System.out.println(message); 
}

/* CORRECCIÓN */
public void imprimirValores() {
	

	String message = String.format("El promedio de las edades es %s y el total de salarios es %s", promedioEdades, totalSalarios);
	System.out.println(message); 
} 

private double calcularPromedioEdades(){
    return this.personal.stream().MapToDouble(persona -> persona.getEdad()).average().orElse(0);
}

private double calcularSalario(){
    return this.personal.stream().MapToDouble(persona -> persona.getSalario()).sum();


}
