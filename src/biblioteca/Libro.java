package biblioteca;

/**
 * Clase base para los libros.
 */
public class Libro {
    private String titulo;
    private Autor autor;
    private boolean disponible;
    private String ISBN;

    public Libro(String titulo, Autor autor, boolean disponible, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
        this.ISBN = ISBN;

        if (autor != null) {
            autor.agregarLibro(this);
        }
    }

    public void prestar() {
        if (!disponible) {
            throw new IllegalStateException("El libro ya está prestado.");
        }
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }

    public String mostrarInformacion() {
        return "Libro: " + titulo
                + " | ISBN: " + ISBN
                + " | Autor: " + (autor != null ? autor.getNombre() : "Sin autor")
                + " | Disponible: " + disponible;
    }

    // Sobrecarga: mismo método, diferente parámetro.
    public String mostrarInformacion(String formato) {
        if ("corto".equalsIgnoreCase(formato)) {
            return titulo + " - " + ISBN;
        }
        return mostrarInformacion();
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) {
        this.autor = autor;
        if (autor != null) {
            autor.agregarLibro(this);
        }
    }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }
}
