## 3 DOCUMENTOS Y ESTADISTICAS Adrian

### Pasos a seguir 
- 1) Detectar y nombrar los malos olores.
- 2) Extraer el código donde se encuentra el "code smells".
- 3) Determinar los refactoring que se van a utilizar.
- 4) Desarrollar el UML con la soución final.
- 5) Expongo el código correjido, con el refactoring aplicado.
- 6) Vuelvo al paso uno. Sino encuentro más code smells termino.

## Protocolo "DOCUMENTOS Y ESTADISTICAS"

```java
public class Document {
    List<String> words;
  
    public long characterCount() {
 	long count = this.words
            .stream()
            .mapToLong(w -> w.length())
            .sum();
    	return count;
	}
    public long calculateAvg() {
    	long avgLength = this.words
            .stream()
            .mapToLong(w -> w.length())
            .sum() / this.words.size();
 	    return avgLength;
	}

// Resto del código que no importa
}
```
### 1. Detectar y nombrar los malos olores
- codigo duplicado, misma logica en characterCount y calculateAvg. 
- Atributo público, rompe el encapsulamiento "Encapsulate Field".
- Variables temporales.

### 2. Determinar refactoring que se van a utilizar.
- Extrac method:           el código duplicado se extrae en un único método.
- Encapsulate Field.       convertimos la varianble de instancia en privada. 
- Replace Temp with Query. se simplifican los métodos eliminando variables temporales.

### 3. Codigo corregido

```java
public class Document {
    List<String> words;
  
    public long characterCount() {
 	long count = this.words.stream().mapToLong(w -> w.length()).sum();
    	return count;
	}

    public long calculateAvg() {
        return this.characterCount()/this.words.size();
    }
}
```
### 4 errores
-  El método calcularAvg(), puede llegar a dividir por cero, si la longitudad de "words.size()" es cero.
- En el mismo metodo calcularAvg se de bería devolver un k double y no un long. Sin embargo no podemos modificar porque estamos refactorizando. Por lo tanto no se puede cambiar el comportamoento externo del sistema.