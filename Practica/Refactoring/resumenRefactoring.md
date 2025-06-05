
---

### 🧼 **Tabla de Code Smells (Malos Olores de Código)**

| Code Smell              | Traducción                | Resumen breve                                              |
| ----------------------- | ------------------------- | ---------------------------------------------------------- |
| **Duplicated Code**     | Código duplicado          | Mismo código en varios lugares. Difícil de mantener.       |
| **Large Class**         | Clase muy grande          | Tiene muchas responsabilidades. Falta de cohesión.         |
| **Large Method**        | Método muy largo          | Difícil de entender y mantener. Debería dividirse.         |
| **Feature Envy**        | Envidia de funcionalidad  | Método que usa más otra clase que la propia.               |
| **Data Class**          | Clase de datos            | Solo tiene atributos y getters/setters. Código procedural. |
| **Condicionales**       | Condicionales repetidos   | Mismos if/else en varios lados. Se sugiere polimorfismo.   |
| **Long Parameter List** | Lista larga de parámetros | Difícil de leer y usar. Mejor agrupar parámetros.          |

---

### 🔧 **Tabla de Refactorings**

| Refactoring                                        | Traducción                                          | Resumen breve                                     |
| -------------------------------------------------- | --------------------------------------------------- | ------------------------------------------------- |
| **Extract Method**                                 | Extraer método                                      | Mover fragmento de código a un nuevo método.      |
| **Inline Method**                                  | Incorporar método                                   | Reemplazar llamada a método por su cuerpo.        |
| **Replace Temp with Query**                        | Reemplazar variable temporal por consulta           | Usar un método en lugar de una variable temporal. |
| **Split Temporary Variable**                       | Dividir variable temporal                           | Separar variables con distintos propósitos.       |
| **Replace Method with Method Object**              | Reemplazar método con objeto de método              | Convertir un método complejo en una clase.        |
| **Substitute Algorithm**                           | Sustituir algoritmo                                 | Cambiar por una implementación más clara.         |
| **Move Method / Field**                            | Mover método / atributo                             | Mover donde más se usa.                           |
| **Extract / Inline Class**                         | Extraer / Incorporar clase                          | Extraer responsabilidades o fusionar clases.      |
| **Remove Middle Man**                              | Eliminar intermediario                              | Evitar delegaciones innecesarias.                 |
| **Hide Delegate**                                  | Ocultar delegación                                  | Exponer un método más directo.                    |
| **Self Encapsulate Field**                         | Autoencapsular atributo                             | Usar getter/setter interno.                       |
| **Encapsulate Field / Collection**                 | Encapsular atributo / colección                     | Controlar acceso a los datos.                     |
| **Replace Data Value with Object**                 | Reemplazar valor simple por objeto                  | Mejor modelado de dominio.                        |
| **Replace Array with Object**                      | Reemplazar array con objeto                         | Clarificar estructura de datos.                   |
| **Replace Magic Number with Constant**             | Reemplazar número mágico con constante              | Usar constantes con significado.                  |
| **Decompose Conditional**                          | Descomponer condicional                             | Separar partes de un if complejo.                 |
| **Consolidate Conditional Expression**             | Consolidar expresiones condicionales                | Unir varias condiciones en una sola.              |
| **Replace Conditional with Polymorphism**          | Reemplazar condicional con polimorfismo             | Subclases definen comportamiento.                 |
| **Rename Method / Field**                          | Renombrar método / atributo                         | Usar nombres claros y descriptivos.               |
| **Preserve Whole Object**                          | Preservar objeto completo                           | Pasar el objeto en lugar de atributos sueltos.    |
| **Introduce Parameter Object**                     | Introducir objeto parámetro                         | Agrupar varios parámetros en un objeto.           |
| **Parameterize Method**                            | Parametrizar método                                 | Generalizar método con parámetros.                |
| **Pull Up / Push Down Field/Method**               | Subir / bajar campo o método                        | Mover lógica a superclase o subclase.             |
| **Extract / Collapse Hierarchy**                   | Extraer / Colapsar jerarquía                        | Ajustar jerarquía según necesidad.                |
| **Replace Inheritance with Delegation**            | Reemplazar herencia con delegación                  | Mejor acoplamiento flexible.                      |
| **Replace Delegation with Inheritance**            | Reemplazar delegación con herencia                  | Simplificar estructura si conviene.               |
| **Form Template Method**                           | Formar método plantilla                             | Extraer pasos comunes en subclases.               |
| **Extract Adapter**                                | Extraer adaptador                                   | Crear clase intermedia para adaptar interfaces.   |
| **Replace Conditional with Strategy**              | Reemplazar condicional con estrategia               | Mover lógica variable a objetos Strategy.         |
| **Replace State-Altering Conditionals with State** | Reemplazar condicionales de estado por patrón State | Modelar transiciones de estado con objetos.       |
| **Move Embellishment to Decorator**                | Mover decoración al decorador                       | Usar patrón Decorator para añadir comportamiento. |
| **Introduce Null Object**                          | Introducir objeto nulo                              | Evitar comprobaciones con `null`.                 |

---
