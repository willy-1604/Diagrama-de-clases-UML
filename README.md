# Sistema de Biblioteca - EA2

Implementación en Java del diagrama de clases UML de la Actividad 1.

## Estructura
- `Persona`: clase abstracta.
- `Usuario` y `Bibliotecario`: heredan de `Persona`.
- `Autor`: agrega una lista de `Libro`.
- `Libro`: clase base.
- `LibroDigital`: hereda de `Libro`.
- `Prestamo`: registra fechas, libro y estado.
- `Biblioteca`: coordina libros, autores y préstamos.
- `Repositorio`: interfaz de almacenamiento.
- `RepositorioMemoria`: implementación en memoria.
- `Main`: prueba y demostración del sistema.

## POO evidenciada
- Abstracción: `Persona` y `Repositorio`.
- Encapsulamiento: atributos `private` y getters/setters.
- Herencia: `Usuario`/`Bibliotecario` extienden `Persona`; `LibroDigital` extiende `Libro`.
- Polimorfismo: una referencia `Libro` contiene un `LibroDigital`.
- Sobrescritura: `mostrarInformacion()` con `@Override`.
- Sobrecarga: `Libro.mostrarInformacion(String)` y `Biblioteca.buscarLibro(...)`.

## SOLID
- **SRP:** cada clase mantiene una responsabilidad principal.
- **OCP:** `LibroDigital` amplía `Libro` sin modificar la clase base.
- **LSP:** `LibroDigital` puede utilizarse donde se espera un `Libro`.
- **ISP:** `Repositorio` mantiene una interfaz pequeña.
- **DIP:** `Biblioteca` recibe `Repositorio` por constructor y depende de la abstracción.

## Ejecución en VS Code
Desde la carpeta del proyecto:

```bash
javac -d out src/biblioteca/*.java
java -cp out biblioteca.Main
```

También se puede ejecutar `Main.java` con la extensión **Extension Pack for Java** de VS Code.

## Control de versiones
Cada integrante debe realizar sus propios cambios y hacer un commit identificable, por ejemplo:
- `Implementa clase Libro con encapsulamiento`
- `Implementa herencia y polimorfismo`
- `Implementa Biblioteca y Repositorio`
- `Agrega pruebas en Main y actualiza README`
