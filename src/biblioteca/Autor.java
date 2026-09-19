package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Autor mantiene una colección de libros.
 * Relación UML: agregación Autor 1..N Libro.
 */
public class Autor {
    private String nombre;
    private String nacionalidad;
    private final List<Libro> libros = new ArrayList<>();

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public void agregarLibro(Libro libro) {
        if (libro != null && !libros.contains(libro)) {
            libros.add(libro);
        }
    }

    public String mostrarInformacion() {
        return "Autor: " + nombre + ", Nacionalidad: " + nacionalidad
                + ", Libros: " + libros.size();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public List<Libro> getLibros() {
        return List.copyOf(libros);
    }
}
