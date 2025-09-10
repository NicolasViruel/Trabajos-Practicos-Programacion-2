package Ejercicio3;

// Asociacion unidireccional: Libro → Autor
// Agregacion: Libro → Editorial
public class Libro {
    private String titulo;
    private String isbn;
    private Autor autor;         // unidireccional
    private Editorial editorial; // agregacion

    public Libro(String titulo, String isbn, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    // como es agregacion, se puede cambiar la editorial libremente
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public Autor getAutor() { return autor; }
    public Editorial getEditorial() { return editorial; }
}
