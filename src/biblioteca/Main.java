package biblioteca;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE BIBLIOTECA PUBLICA =====");

        // Implementación concreta del repositorio.
        RepositorioMemoria repositorio = new RepositorioMemoria();

        // Biblioteca depende de la abstracción Repositorio (DIP).
        Biblioteca biblioteca = new Biblioteca(
                "Biblioteca Digital",
                "Medellín, Antioquia",
                repositorio
        );

        // Autores: agregación con Libro.
        Autor autor1 = new Autor("Miguel de Cervantes", "Española");
        Autor autor2 = new Autor("Antoine de Saint-Exupéry", "Francesa");
        Autor autor3 = new Autor("Gabriel García Márquez", "Colombiana");

        biblioteca.registrarAutor(autor1);
        biblioteca.registrarAutor(autor2);
        biblioteca.registrarAutor(autor3);

        // Libros: relación Libro -> Autor.
        Libro libro1 = new Libro(
                "Don Quijote de la Mancha",
                autor1,
                true,
                "ISBN-001"
        );

        Libro libro2 = new Libro(
                "Cien años de soledad",
                autor3,
                true,
                "ISBN-002"
        );

        LibroDigital libro3 = new LibroDigital(
                "El Principito",
                autor2,
                true,
                "ISBN-003",
                "PDF",
                5.5
        );

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        System.out.println("\n--- REGISTRO DE LIBROS BIBLIOTECA ---");
        System.out.println(libro1.mostrarInformacion());
        System.out.println(libro2.mostrarInformacion());
        System.out.println(libro3.mostrarInformacion());

        // Sobrecarga de mostrarInformacion().
        System.out.println("\nSobrecarga: " + libro1.mostrarInformacion("corto"));

        // Polimorfismo: una referencia Libro apunta a un LibroDigital.
        System.out.println("\n---  PILAR POLIMORFISMO ---");
        Libro libroPolimorfico = libro3;
        System.out.println(libroPolimorfico.mostrarInformacion());

        // Herencia + sobrescritura.
        System.out.println("\n--- PERSONAS ---");
        Persona usuario = new Usuario(
                1, "Willy Anderson", "1017149179", "USR-001"
        );

        Persona bibliotecario = new Bibliotecario(
                2, "Carlos Pérez", "12345678", "EMP-001", "Administrador"
        );

        System.out.println(usuario.mostrarInformacion());
        System.out.println(bibliotecario.mostrarInformacion());

        // Préstamo.
        System.out.println("\n--- PRÉSTAMO ---");
        Usuario usuarioReal = (Usuario) usuario;
        Prestamo prestamo = usuarioReal.prestarLibro(libro1);
        biblioteca.registrarPrestamo(prestamo);

        System.out.println(prestamo);
        System.out.println("Días calculados: " + prestamo.calcularDias());
        System.out.println("Libro disponible: " + libro1.estaDisponible());

        // Bibliotecario registra operaciones.
        Bibliotecario empleado = (Bibliotecario) bibliotecario;
        empleado.registrarLibro(biblioteca, libro3);

        // Devolución.
        System.out.println("\n--- SISTEMA DEVOLUCIÓN ---");
        usuarioReal.devolverLibro(prestamo);
        System.out.println(prestamo);
        System.out.println("Libro disponible/s: " + libro1.estaDisponible());

        // Libro digital.
        System.out.println("\n--- LIBRO DIGITAL ---");
        libro3.descargar();

        // Búsqueda en el repositorio.
        System.out.println("\n--- POR BÚSQUEDA ---");
        Libro encontrado = biblioteca.buscarLibro("Cien años de soledad");
        System.out.println(encontrado != null
                ? "Libro encontrado: " + encontrado.mostrarInformacion()
                : "Libro no encontrado.");

        System.out.println("\n--- RESUMEN ---");
        System.out.println(biblioteca.mostrarInformacion());
        System.out.println("Libros almacenados: " + repositorio.listarLibros().size());
        System.out.println("===== FIN DEL SISTEMA =====");
    }
}
