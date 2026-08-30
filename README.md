Diagrama de Clases UML 

## Introducción

Este proyecto presenta el diseño de un Diagrama de Clases UML para un sistema orientado
a objetos de gestión de una biblioteca.

El diseño busca representar de manera organizada las principales entidades del sistema y las 
relaciones entre ellas, aplicando conceptos fundamentales de la programación orientada a objetos.

## Objetivo

Diseñar un Diagrama de Clases UML que permita modelar la solución de un sistema de biblioteca 
aplicando abstracción, encapsulamiento, herencia, polimorfismo, sobrecarga y sobrescritura.

También se consideran criterios de diseño como cohesión, bajo acoplamiento y principios SOLID.

-Conceptos aplicados
-Abstracción
-Encapsulamiento
-Herencia
-Polimorfismo
-Sobrecarga
-Sobrescritura
-Cohesión
-Bajo acoplamiento
-Principios SOLID
-Clases principales

El sistema está compuesto por las siguientes clases:

-Persona (clase abstracta)
-Usuario
-Bibliotecario
-Autor
-Libro
-LibroDigital
-Préstamo
-Biblioteca
-Repositorio (interfaz)
-Descripción del diseño

La clase abstracta Persona representa las características comunes de las personas 
que participan en el sistema (id, nombre, documento).

Usuario y Bibliotecario heredan de Persona, reutilizando sus atributos 
y comportamientos comunes (herencia).

La clase Libro representa las características generales de un libro 
(título, autor, disponibilidad, ISBN). A partir de ella, LibroDigital hereda sus
atributos y sobrescribe el método mostrarInformacion() para adaptarlo a sus propias 
características (formato, tamaño de archivo), aplicando así polimorfismo y sobrescritura.

La clase Autor se relaciona con Libro mediante una asociación
(un autor puede escribir varios libros).

La clase Préstamo representa la operación de préstamo de un libro, 
con sus fechas de préstamo y devolución, y su estado.

La clase Biblioteca gestiona el conjunto de libros, autores y préstamos del sistema,
y depende de la interfaz Repositorio (guardarLibro, buscarLibro) en lugar de una implementación concreta,
aplicando el principio de inversión de dependencias.

## Encapsulamiento

Los atributos de las clases se manejan mediante modificadores de acceso 
privados (-) y métodos públicos (+) para consultar o modificar la información.

## Herencia

La herencia permite que las clases especializadas reutilicen las características de las clases generales:

-Usuario y Bibliotecario heredan de Persona.
-LibroDigital hereda de Libro.
-Polimorfismo y sobrescritura

El polimorfismo permite trabajar con diferentes tipos de objetos mediante una referencia 
común (por ejemplo, tratar un LibroDigital como un Libro).

La sobrescritura se evidencia en LibroDigital, que redefine el método mostrarInformacion() heredado 
de Libro para incluir información adicional propia del formato digital.

## Sobrecarga

La sobrecarga se aplica en la clase Libro, que define dos versiones del método mostrarInformacion(): 
una sin parámetros y otra que recibe un parámetro formato: String, ofreciendo distintas formas de
obtener la información del libro.

## Cohesión y bajo acoplamiento

Cada clase mantiene responsabilidades relacionadas con su propósito (por ejemplo,
Préstamo solo gestiona la información del préstamo, no la del libro ni la del usuario), 
favoreciendo una alta cohesión.

El uso de la interfaz Repositorio para el acceso a datos reduce las dependencias directas
entre Biblioteca y una implementación concreta de almacenamiento, manteniendo un bajo acoplamiento.

## Principios SOLID

El diseño considera principalmente:

Responsabilidad única (S): cada clase tiene una función específica 
(Usuario gestiona préstamos propios, Bibliotecario administra el catálogo,
Préstamo registra la operación, etc.).
Abierto/cerrado (O): el sistema puede extenderse con nuevos tipos de libro
(como LibroDigital) sin modificar la clase base Libro.
Sustitución de Liskov (L): las clases derivadas (LibroDigital, Usuario, Bibliotecario) 
pueden utilizarse donde se espera su clase base (Libro, Persona).
Inversión de dependencias (D): Biblioteca depende de la abstracción Repositorio,
no de una implementación concreta.
Datos concretos del sistema

Para validar el modelo, el diagrama incluye un ejemplo con instancias reales
de 3 libros, sus autores y sus préstamos:

## Libro	Autor	Préstamo
-Don Quijote de la Mancha	Miguel de Cervantes (Española)	20/08/2026 → 27/08/2026
-Cien años de soledad	Gabriel García Márquez (Colombiana)	21/08/2026 → 28/08/2026
-El principito	Antoine de Saint-Exupéry (Francesa)	22/08/2026 → 29/08/2026


El archivo editable del diagrama se encuentra en: EA1_DiagramaClases_Grupo18_.drawio

La representación gráfica del diagrama se encuentra en: EA1_DiagramaClases_Grupo18__pdf_drawio.png

Enlace al video: PENDIENTE DE AGREGAR

## Integrantes
Willy Anderson Jaramillo Ortiz -
Franciny Alberto Cano Quinchia 

## Conclusiones

Con este proyecto logramos el objetivo que nos planteamos: modelar un sistema de biblioteca
usando los conceptos de programación orientada a objetos que hemos visto. Se nota la herencia en cómo Persona
le pasa sus atributos a Usuario y Bibliotecario, y cómo Libro hace lo mismo con LibroDigital; esta última clase además sobrescribe
mostrarInformacion() para mostrar sus propios datos, y Libro en sí usa sobrecarga al tener dos versiones de ese mismo método.
El encapsulamiento se ve en que todos los atributos son privados y se accede a ellos por métodos públicos, y hasta metimos 
un poco de SOLID al hacer que Biblioteca dependa de la interfaz Repositorio en vez de depender de algo concreto.

Y más allá de la nota, esto sirve para la vida real: modelar antes de programar ayuda a no meter la pata con el diseño
y deja una documentación que le sirve a cualquiera que llegue después al proyecto. Trabajar con Git y GitHub también 
fue un buen ensayo de cómo se maneja un proyecto en equipo de verdad, subiendo cambios de forma ordenada sin pisarnos el trabajo entre nosotroS.
