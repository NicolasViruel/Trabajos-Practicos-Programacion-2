package Ejercicio_2;

public class MainEjercicio2 {
    public static void run() {
        System.out.println("EJERCICIO 2: Biblioteca y Libros ");

        // 1) Creamos una biblioteca
        Biblioteca biblio = new Biblioteca("Biblioteca Central");

        // 2) Crear al menos tres autores
        Autor a1 = new Autor("A01", "Julio Cortázar", "Argentina");
        Autor a2 = new Autor("A02", "Isabel Allende", "Chile");
        Autor a3 = new Autor("A03", "Gabriel García Márquez", "Colombia");

        // 3) Agregar 5 libros asociados a alguno de los autores
        biblio.agregarLibro("ISBN-001", "Rayuela", 1963, a1);
        biblio.agregarLibro("ISBN-002", "Bestiario", 1951, a1);
        biblio.agregarLibro("ISBN-003", "La casa de los espíritus", 1982, a2);
        biblio.agregarLibro("ISBN-004", "Cuentos de Eva Luna", 1989, a2);
        biblio.agregarLibro("ISBN-005", "Cien años de soledad", 1967, a3);

        // 4) Listar todos los libros con info completa
        System.out.println("\n4) Listado de libros:");
        biblio.listarLibros();

        // 5) Buscar un libro por ISBN
        System.out.println("\n5) Buscar libro por ISBN 'ISBN-003':");
        biblio.buscarLibroPorIsbn("ISBN-003")
                .ifPresentOrElse(Libro::mostrarInfo, () -> System.out.println("No encontrado."));

        // 6) Filtrar por año
        int anio = 1982;
        System.out.println("\n6) Libros publicados en " + anio + ":");
        for (Libro l : biblio.filtrarLibrosPorAnio(anio)) l.mostrarInfo();

        // 7) Eliminar un libro y listar restantes
        System.out.println("\n7) Eliminar ISBN-002:");
        System.out.println("Eliminado: " + biblio.eliminarLibro("ISBN-002"));
        System.out.println("Listado actualizado:");
        biblio.listarLibros();

        // 8) Cantidad total de libros
        System.out.println("\n8) Cantidad total de libros: " + biblio.obtenerCantidadLibros());

        // 9) Listar autores disponibles en la biblioteca
        System.out.println("\n9) Autores disponibles:");
        biblio.mostrarAutoresDisponibles();

    }
}
