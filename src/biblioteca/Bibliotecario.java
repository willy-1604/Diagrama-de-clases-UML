package biblioteca;

/**
 * Bibliotecario hereda de Persona y administra el sistema.
 */
public class Bibliotecario extends Persona {
    private String codigoEmpleado;
    private String cargo;

    public Bibliotecario(int id, String nombre, String documento,
                         String codigoEmpleado, String cargo) {
        super(id, nombre, documento);
        this.codigoEmpleado = codigoEmpleado;
        this.cargo = cargo;
    }

    public void registrarLibro(Biblioteca biblioteca, Libro libro) {
        biblioteca.agregarLibro(libro);
    }

    public void registrarAutor(Biblioteca biblioteca, Autor autor) {
        biblioteca.registrarAutor(autor);
    }

    public void registrarPrestamo(Biblioteca biblioteca, Prestamo prestamo) {
        biblioteca.registrarPrestamo(prestamo);
    }

    @Override
    public String mostrarInformacion() {
        return "Bibliotecario -> " + super.mostrarInformacion()
                + ", Código empleado: " + codigoEmpleado
                + ", Cargo: " + cargo;
    }

    public String getCodigoEmpleado() { return codigoEmpleado; }
    public void setCodigoEmpleado(String codigoEmpleado) { this.codigoEmpleado = codigoEmpleado; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}
