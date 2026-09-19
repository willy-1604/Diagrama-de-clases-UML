package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Usuario hereda de Persona.
 * POO: Herencia, encapsulamiento y polimorfismo.
 */
public class Usuario extends Persona {
    private String codigoUsuario;
    private int limitePrestamos = 3;
    private final List<Prestamo> prestamos = new ArrayList<>();

    public Usuario(int id, String nombre, String documento, String codigoUsuario) {
        super(id, nombre, documento);
        this.codigoUsuario = codigoUsuario;
    }

    public Prestamo prestarLibro(Libro libro) {
        if (prestamos.size() >= limitePrestamos) {
            throw new IllegalStateException("El usuario ya alcanzó el límite de " + limitePrestamos + " préstamos.");
        }

        if (!libro.isDisponible()) {
            throw new IllegalStateException("El libro no está disponible.");
        }

        libro.prestar();
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucion = fechaPrestamo.plusDays(7);

        Prestamo prestamo = new Prestamo(fechaPrestamo, fechaDevolucion, libro);
        prestamos.add(prestamo);
        return prestamo;
    }

    public void devolverLibro(Prestamo prestamo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo.");
        }

        prestamo.registrarDevolucion();
        prestamos.remove(prestamo);
    }

    @Override
    public String mostrarInformacion() {
        return "Usuario -> " + super.mostrarInformacion()
                + ", Código: " + codigoUsuario
                + ", Préstamos activos: " + prestamos.size();
    }

    public String getCodigoUsuario() { return codigoUsuario; }
    public void setCodigoUsuario(String codigoUsuario) { this.codigoUsuario = codigoUsuario; }

    public int getLimitePrestamos() { return limitePrestamos; }
    public void setLimitePrestamos(int limitePrestamos) {
        if (limitePrestamos < 1) {
            throw new IllegalArgumentException("El límite debe ser mayor que cero.");
        }
        this.limitePrestamos = limitePrestamos;
    }

    public List<Prestamo> getPrestamos() {
        return List.copyOf(prestamos);
    }
}
