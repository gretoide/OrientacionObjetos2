# 2.2 Juegos

```java

public class Juego {
    // Métodos para modificar la puntuación de un jugador
    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }

    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }

    // Clase anidada Jugador
    public class Jugador {
        public String nombre;
        public String apellido;
        public int puntuacion = 0;
    }
}
```

##
