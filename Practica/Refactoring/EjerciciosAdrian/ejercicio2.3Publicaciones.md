
### Pasos a seguir 
- 1) Detectar y nombrar los malos olores.
- 2) Extraer el código donde se encuentra el "code smells".
- 3) Determinar los refactoring que se van a utilizar.
- 4) Desarrollar el UML con la soución final.
- 5) Expongo el código correjido, con el refactoring aplicado.
- 6) Vuelvo al paso uno. Sino encuentro más code smells termino.

## 1.1 Protocolo de "PodtApp"

![alt text](image-1.png)

```java
/**
* Retorna los últimos N posts que no pertenecen al usuario user
*/
public List<Post> ultimosPosts(Usuario user, int cantidad) {
    List<Post> postsOtrosUsuarios = new ArrayList<Post>();
    
    for (Post post : this.posts) {
        if (!post.getUsuario().equals(user)) {
            postsOtrosUsuarios.add(post);
        }
    }
    // ordena los posts por fecha
    for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
        int masNuevo = i;
        for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
            if (postsOtrosUsuarios.get(j).getFecha().isAfter(postsOtrosUsuarios.get(masNuevo).getFecha())) {
                masNuevo = j;
            }
        }
        Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
        postsOtrosUsuarios.set(masNuevo, unPost);
    }
    List<Post> ultimosPosts = new ArrayList<Post>();
    int index = 0;
    Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
    while (postIterator.hasNext() && index < cantidad) {
        ultimosPosts.add(postIterator.next());
    }
    return ultimosPosts;
}
```
## 1 Detectar y nombrar los malos olores.

- Metodo demaciado largo, 
- nombre poco decriptivo
- reinventar la rueda al no utilizar las herramientas provistas po el lenguaje.


## 2 Extraer el código donde se encuentra el "code smells".

-TODO EL CÓDIGO QUE SE MUESTRA ARRIBA

## 3 Rename method, extract method, move method.


## 4 Diseño UML

## 5 Expongo el código correjido, con el refactoring aplicado.


```java
public List<Post> ultimosPostsNoPertenecientesAlUsaurio(Usuario user, int cantidad) {
    List<Post> postsOtrosUsuarios = postNoPertenecientesAlUsuario(user);
    postsOtrosUsuarios = ordenadaPorFecha(postsOtrosUsuarios);
    return obtenerUltimosNPost(postsOtrosUsuarios);
}

private List<Post> postPorOtrosUsuarios(Usuario user){
    return this.posts.stream().filter(post -> !post.getUsuario().equals(user));    
}

private List<Post> ordenarPostPorFecha(List<Post> lista){
    return  lista.strem().sorted((fech1, fech2) -> fech1.getFecha().compareTo(fech2.getFecha())).collect(Collectors.toList()) ;
}

private List<Post> obtenerUltimosNPost(List<Post> lista, int cantidad){
    return lista.strem().limit(cantidad).collect(Collectrs.tiList());
}


/**
* Retorna los últimos N posts que no pertenecen al usuario user
*/
public List<Post> ultimosPosts(Usuario user, int cantidad) {

   List<Post> postsOtrosUsuarios = new ArrayList<Post>();    
   for (Post post : this.posts) {
        if (!post.getUsuario().equals(user)) {
            postsOtrosUsuarios.add(post);
        }
    }
    //CORRECCIÓN
    }
    // ordena los posts por fecha
    for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
        int masNuevo = i;
        for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
            if (postsOtrosUsuarios.get(j).getFecha().isAfter(postsOtrosUsuarios.get(masNuevo).getFecha())) {
                masNuevo = j;
            }
        }
        Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
        postsOtrosUsuarios.set(masNuevo, unPost);
    }
    List<Post> ultimosPosts = new ArrayList<Post>();
    int index = 0;
    Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
    while (postIterator.hasNext() && index < cantidad) {
        ultimosPosts.add(postIterator.next());
    }
```


