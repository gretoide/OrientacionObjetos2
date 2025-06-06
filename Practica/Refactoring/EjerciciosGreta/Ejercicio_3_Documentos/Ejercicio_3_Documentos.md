

## 3. Documentos y Estadísticas

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

### 1. Code Smells identificados

* **Código duplicado**: misma lógica en `characterCount()` y `calculateAvg()`.
* **Ruptura del encapsulamiento**: la variable de instancia es pública.
* **Variables temporales** dentro de los métodos.

### 2. Refactorings a utilizar

* **Encapsulate Field**: se convierte la variable de instancia en privada.
* **Extract Method**: el comportamiento repetido se extrae en un único método.
* **Replace Temp with Query**: se simplifican los métodos eliminando variables temporales.

### 3. Resultado

```java
public class Document {
    private List<String> words;

    public long characterCount() {
        return this.words.stream().mapToLong(w -> w.length()).sum();
    }

    public long calculateAvg() {
        return this.characterCount() / this.words.size();
    }

    // Resto del código que no importa
}
```


## Errores detectados

* **Error 1**: no se contempla la división por cero en el método `calculateAvg()`.
* **Error 2**: en el mismo método `calculateAvg()`, se debería retornar un `Double` y no un `Long`. Sin embargo, no podemos modificar esto ya que, al refactorizar, **no se debe cambiar el comportamiento externo del sistema**.

