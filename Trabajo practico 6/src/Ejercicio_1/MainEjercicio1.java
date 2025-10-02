package Ejercicio_1;

import common.CategoriaProducto;
import common.Producto;

public class MainEjercicio1 {
    public static void run() {
        Inventario inv = new Inventario();

        System.out.println("1) Crear 5 productos y agregarlos:");
        Producto p1 = new Producto("A1", "Arroz", 950.0, 50, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("E1", "Auriculares", 2500.0, 20, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("R1", "Remera", 1800.0, 35, CategoriaProducto.ROPA);
        Producto p4 = new Producto("H1", "Silla", 5200.0, 12, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("A2", "Yerba", 1400.0, 80, CategoriaProducto.ALIMENTOS);
        inv.agregarProducto(p1); inv.agregarProducto(p2); inv.agregarProducto(p3); inv.agregarProducto(p4); inv.agregarProducto(p5);

        System.out.println("\n2) Listar todos:");
        inv.listarProductos();

        System.out.println("\n3) Buscar 'R1':");
        inv.buscarProductoPorId("R1").ifPresentOrElse(Producto::mostrarInfo, () -> System.out.println("No encontrado."));

        System.out.println("\n4) Filtrar por ALIMENTOS:");
        for (Producto p : inv.filtrarPorCategoria(CategoriaProducto.ALIMENTOS)) p.mostrarInfo();

        System.out.println("\n5) Eliminar 'E1' y listar restantes:");
        System.out.println("Eliminado: " + inv.eliminarProducto("E1"));
        inv.listarProductos();

        System.out.println("\n6) Actualizar stock de 'A2' a 100:");
        System.out.println("Actualizado: " + inv.actualizarStock("A2", 100));
        inv.buscarProductoPorId("A2").ifPresent(Producto::mostrarInfo);

        System.out.println("\n7) Total stock:");
        System.out.println(inv.obtenerTotalStock());

        System.out.println("\n8) Producto con mayor stock:");
        inv.obtenerProductoConMayorStock().ifPresent(Producto::mostrarInfo);

        System.out.println("\n9) Precio entre $1000 y $3000:");
        for (Producto p : inv.filtrarProductosPorPrecio(1000, 3000)) p.mostrarInfo();

        System.out.println("\n10) Categorías disponibles:");
        inv.mostrarCategoriasDisponibles();
    }
}
