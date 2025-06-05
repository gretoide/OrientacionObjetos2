# 2.1 Carrito de Compras

![alt text](.\UMLyArchivos\image-4.png)

```java
public class Producto {
    private String nombre;
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public Producto getProducto() {
        return this.producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }
}

public class Carrito {
    private List<ItemCarrito> items;

    public double total() {
        return this.items.stream()
            .mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidad())
            .sum();
    }
}

```

### 1. Code Smells
- Envidia de atributos, ya que el responsable de calcular el precio, le corresponde al mismo ItemCarrito.
- Clase de Datos, ya que ItemCarrito no estaría haciendo nada.

### 2. Refactoring a Utilizar
- Extract Method
- Move Method
  
### 3. Resultado:

#### 1. Extract Method
![alt text](.\UMLyArchivos\image-5.png)

```java

public class Carrito {
    private List<ItemCarrito> items;

    public double total() {
		return this.items.stream().mapToDouble(item -> calcularTotalItem(item)).sum();
	}

    public double calcularTotalItem(ItemCarrito item) {
        return item.getProducto().getPrecio() * item.getCantidad();
    }
}

```

#### 2. Move Method
![alt text](.\UMLyArchivos\image-6.png)

```java
public class Producto {
    private String nombre;
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public double calcularTotalItem(ItemCarrito item) {
        return item.getProducto().getPrecio() * item.getCantidad();
    }

    public Producto getProducto() {
        return this.producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }
}

public class Carrito {
    private List<ItemCarrito> items;

    public double total() {
		return this.items.stream().mapToDouble(item -> calcularTotalItem(item)).sum();
	}
}

```