package common;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;

    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public CategoriaProducto getCategoria() { return categoria; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setCategoria(CategoriaProducto categoria) { this.categoria = categoria; }

    public void mostrarInfo() {
        System.out.printf(
                "ID: %s | Nombre: %s | Precio: $%.2f | Cantidad: %d | Categoría: %s (%s)%n",
                id, nombre, precio, cantidad, categoria.name(), categoria.getDescripcion()
        );
    }

    @Override
    public String toString() {
        return String.format("%s - %s ($%.2f) x%d [%s]", id, nombre, precio, cantidad, categoria.name());
    }
}
