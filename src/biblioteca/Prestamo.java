package biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Clase que representa el préstamo de un libro.
 * La referencia al libro forma parte de la composición del préstamo.
 */
public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private final Libro libro;
    private String estado;

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro) {
        if (fechaPrestamo == null || fechaDevolucion == null || libro == null) {
            throw new IllegalArgumentException("Las fechas y el libro son obligatorios.");
        }

        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.estado = "ACTIVO";
    }

    public void registrarDevolucion() {
        this.fechaDevolucion = LocalDate.now();
        this.estado = "DEVUELTO";
        libro.devolver();
    }

    public int calcularDias() {
        return (int) ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucion);
    }

    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDate fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public Libro getLibro() { return libro; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Préstamo{libro='" + libro.getTitulo()
                + "', fechaPrestamo=" + fechaPrestamo
                + ", fechaDevolucion=" + fechaDevolucion
                + ", estado='" + estado + "'}";
    }
}
