package libro;

public class Libro {
    // Atributos privados
    private String titulo;
    private String autor;
    private int anioPublicacion;

    // Constructor
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        setAnioPublicacion(anioPublicacion); // validación en el setter
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    // Setter con validacion
    public void setAnioPublicacion(int anioPublicacion) {
        int anioActual = java.time.Year.now().getValue();
        if (anioPublicacion < 1 || anioPublicacion > anioActual) {
            System.out.println(" Año invalido: " + anioPublicacion);
        } else {
            this.anioPublicacion = anioPublicacion;
        }
    }

    // Metodo para mostrar info
    public void mostrarInfo() {
        System.out.println("Libro: \"" + titulo + "\" de " + autor + " (" + anioPublicacion + ")");
    }
}