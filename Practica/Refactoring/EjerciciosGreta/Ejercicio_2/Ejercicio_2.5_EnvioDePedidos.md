# 2.5 Envio de Pedidos

![alt text](.\UMLyArchivos\image-7.png)

```java
import java.text.MessageFormat;

public class Supermercado {
    public void notificarPedido(long nroPedido, Cliente cliente) {
        String notificacion = MessageFormat.format(
            "Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}",
            new Object[] { nroPedido, cliente.getDireccionFormateada() }
        );
        // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
        System.out.println(notificacion);
    }
}

public class Cliente {
    private Direccion direccion;

    public String getDireccionFormateada() {
        return this.direccion.getLocalidad() + ", " +
               this.direccion.getCalle() + ", " +
               this.direccion.getNumero() + ", " +
               this.direccion.getDepartamento();
    }
}


```