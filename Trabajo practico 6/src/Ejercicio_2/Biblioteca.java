package Ejercicio_2;

import java.util.*;

public class Biblioteca {
    private final String nombre;
    private final List<Libro> libros = new ArrayList<>();

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    // Composición: los libros se crean y se gestionan “dentro” de la Biblioteca
    public boolean agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        if (buscarLibroPorIsbn(isbn).isPresent()) return false; // evitar duplicados
        return libros.add(new Libro(isbn, titulo, anioPublicacion, autor));
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca \"" + nombre + "\".");
            return;
        }
        for (Libro l : libros) l.mostrarInfo(); // for-each
    }

    public Optional<Libro> buscarLibroPorIsbn(String isbn) {
        for (Libro l : libros) if (l.getIsbn().equalsIgnoreCase(isbn)) return Optional.of(l);
        return Optional.empty();
    }

    public boolean eliminarLibro(String isbn) {
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            if (it.next().getIsbn().equalsIgnoreCase(isbn)) { it.remove(); return true; }
        }
        return false;
    }

    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public List<Libro> filtrarLibrosPorAnio(int anio) {
        List<Libro> res = new ArrayList<>();
        for (Libro l : libros) if (l.getAnioPublicacion() == anio) res.add(l);
        return res;
    }

    public void mostrarAutoresDisponibles() {
        // Usamos LinkedHashSet para evitar repetidos y mantener orden de inserción
        Set<String> autores = new LinkedHashSet<>();
        for (Libro l : libros) autores.add(l.getAutor().toString());
        if (autores.isEmpty()) {
            System.out.println("No hay autores cargados.");
            return;
        }
        System.out.println("Autores en \"" + nombre + "\":");
        for (String a : autores) System.out.println(" - " + a);
    }

    // Solo lectura (no exponer la lista interna)
    public List<Libro> getLibros() {
        return Collections.unmodifiableList(libros);
    }
}
