package biblioteca;

/**
 * Abstracción para el almacenamiento de libros.
 * SOLID - DIP: Biblioteca depende de esta interfaz y no de una implementación concreta.
 * SOLID - ISP: la interfaz es pequeña y tiene solo las operaciones necesarias.
 */
public interface Repositorio {
    void guardarLibro(Libro libro);
    Libro buscarLibro(String titulo);
}
