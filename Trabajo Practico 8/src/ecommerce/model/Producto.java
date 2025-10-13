package ecommerce.model;

import ecommerce.billing.Pagable;

public class Producto implements Pagable, Comparable<Producto> {
    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser vacío");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    @Override public double calcularTotal() { return precio; }

    @Override public String toString() { return nombre + " ($" + precio + ")"; }

    @Override
    public int compareTo(Producto o) {
        int byName = this.nombre.compareToIgnoreCase(o.nombre);
        if (byName != 0) return byName;
        return Double.compare(this.precio, o.precio);
    }
}