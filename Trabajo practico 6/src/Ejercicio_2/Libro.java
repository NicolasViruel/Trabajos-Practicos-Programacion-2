package Ejercicio_2;

public class Libro {
    private final String isbn;
    private String titulo;
    private int anioPublicacion;
    private final Autor autor; // composición: el libro pertenece a una biblioteca y tiene un autor

    // Constructor público: lo crearemos desde Biblioteca.agregarLibro(...)
    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public Autor getAutor() { return autor; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public void mostrarInfo() {
        System.out.printf("Libro: \"%s\" | ISBN: %s | Año: %d | Autor: %s%n",
                titulo, isbn, anioPublicacion, autor);
    }

    @Override
    public String toString() {
        return "\"" + titulo + "\" (" + anioPublicacion + ") - " + autor + " [" + isbn + "]";
    }
}
