# 2.1 Peliculas

![alt text](.\UMLyArchivos\image-9.png)

```java
public class Usuario {
    String tipoSubscripcion;
    // ...

    public void setTipoSubscripcion(String unTipo) {
   	 this.tipoSubscripcion = unTipo;
    }
    
    public double calcularCostoPelicula(Pelicula pelicula) {
   	 double costo = 0;
   	 if (tipoSubscripcion=="Basico") {
   		 costo = pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
   	 }
   	 else if (tipoSubscripcion== "Familia") {
   		 costo = (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
   	 }
   	 else if (tipoSubscripcion=="Plus") {
   		 costo = pelicula.getCosto();
   	 }
   	 else if (tipoSubscripcion=="Premium") {
   		 costo = pelicula.getCosto() * 0.75;
   	 }
   	 return costo;
    }
}

public class Pelicula {
    LocalDate fechaEstreno;
    // ...

    public double getCosto() {
   	 return this.costo;
    }
    
    public double calcularCargoExtraPorEstreno(){
	// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
   	return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
    }
}

```

### 1. Identificar los code smell
- Método largo.
- Presencia de condicionales.

### 2. Refactoring a utilizar
- Replace Conditional with Strategy: creamos la clase abstracta 'Subscripcion' con sus respectivas estrategias (Subcripciones Basica, Familiar, Premium y Plus).
- Move Method: movemos los cálculos dentro del método que se encuentra en Usuario a las estrategias.
- Dejar un método en el contexto (clase Usuario) para poder 'configurar' la estrategia.
- Dejamos otro método en el contexto para delegar.

### 3. Resultado:

![alt text](.\UMLyArchivos\image-10.png)

```java
public class Usuario {
    private Subscripcion tipoSubscripcion;
    private ArrayList<Pelicula> peliculasCompradas;

    public void setTipoSubscripcion(Subscripcion unTipo) {
   	 this.tipoSubscripcion = unTipo;
    }
    
    public double calcularCostoPelicula(Pelicula pelicula) {
        return this.tipoSubscripcion.calcularCostoPelicular(pelicula);
    }
}

public class Pelicula {
    LocalDate fechaEstreno;
    // ...

    public double getCosto() {
   	 return this.costo;
    }
    
    public double calcularCargoExtraPorEstreno(){
	// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
   	return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
    }
}

public abstract class Subscripcion{
    abstract double calcularCostoPelicula(Pelicula unaPelicula);
}

public class SubscripcionBasica extends Subscripcion{
	
	public double calcularCostoPelicula(Pelicula pelicula) {
		return pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
	}

}

public class SubscripcionFamilia extends Subscripcion{

	public double calcularCostoPelicula(Pelicula pelicula) {
		return (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
	}

}

public class SubscripcionPlus extends Subscripcion{

	public double calcularCostoPelicula(Pelicula pelicula) {
		return pelicula.getCosto();
	}

}

public class SubscripcionPremium extends Subscripcion{

	public double calcularCostoPelicula(Pelicula pelicula) {
		return pelicula.getCosto() * 0.75;
	}

}

```