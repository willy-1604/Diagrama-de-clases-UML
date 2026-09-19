package biblioteca;

/**
 * Subclase de Libro.
 * POO: Herencia, polimorfismo y sobrescritura.
 */
public class LibroDigital extends Libro {
    private String formato;
    private double tamanoArchivo;

    public LibroDigital(String titulo, Autor autor, boolean disponible,
                        String ISBN, String formato, double tamanoArchivo) {
        super(titulo, autor, disponible, ISBN);
        this.formato = formato;
        this.tamanoArchivo = tamanoArchivo;
    }

    public void descargar() {
        if (!isDisponible()) {
            throw new IllegalStateException("El libro digital no está disponible para descarga.");
        }
        System.out.println("Descargando: " + getTitulo() + " (" + formato + ")");
    }

    @Override
    public String mostrarInformacion() {
        return "Libro Digital -> " + super.mostrarInformacion()
                + " | Formato: " + formato
                + " | Tamaño: " + tamanoArchivo + " MB";
    }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }

    public double getTamanoArchivo() { return tamanoArchivo; }
    public void setTamanoArchivo(double tamanoArchivo) { this.tamanoArchivo = tamanoArchivo; }
}
