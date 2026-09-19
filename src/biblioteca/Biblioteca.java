package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona la colección, autores y préstamos.
 * SOLID - SRP: su responsabilidad se centra en coordinar la biblioteca.
 * SOLID - DIP: recibe un Repositorio por inyección de dependencias.
 */
public class Biblioteca {
    private String nombre;
    private String direccion;
    private final List<Autor> autores = new ArrayList<>();
    private final List<Prestamo> prestamos = new ArrayList<>();
    private final Repositorio repositorio;

    public Biblioteca(String nombre, String direccion, Repositorio repositorio) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.repositorio = repositorio;
    }

    public void agregarLibro(Libro libro) {
        repositorio.guardarLibro(libro);
    }

    public void registrarAutor(Autor autor) {
        if (autor != null && !autores.contains(autor)) {
            autores.add(autor);
        }
    }

    public void registrarPrestamo(Prestamo prestamo) {
        if (prestamo != null && !prestamos.contains(prestamo)) {
            prestamos.add(prestamo);
        }
    }

    public Libro buscarLibro(String titulo) {
        return repositorio.buscarLibro(titulo);
    }

    // Sobrecarga adicional para buscar por ISBN.
    public Libro buscarLibro(String titulo, String ISBN) {
        Libro libro = repositorio.buscarLibro(titulo);
        if (libro != null && libro.getISBN().equalsIgnoreCase(ISBN)) {
            return libro;
        }
        return null;
    }

    public String mostrarInformacion() {
        return "Biblioteca: " + nombre
                + " | Dirección: " + direccion
                + " | Autores registrados: " + autores.size()
                + " | Préstamos registrados: " + prestamos.size();
    }

    public List<Autor> getAutores() { return List.copyOf(autores); }
    public List<Prestamo> getPrestamos() { return List.copyOf(prestamos); }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}
