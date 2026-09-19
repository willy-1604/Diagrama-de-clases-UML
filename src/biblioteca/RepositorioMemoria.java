package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación sencilla del repositorio usando memoria.
 */
public class RepositorioMemoria implements Repositorio {
    private final List<Libro> libros = new ArrayList<>();

    @Override
    public void guardarLibro(Libro libro) {
        if (libro != null && !libros.contains(libro)) {
            libros.add(libro);
        }
    }

    @Override
    public Libro buscarLibro(String titulo) {
        return libros.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Libro> listarLibros() {
        return List.copyOf(libros);
    }
}
