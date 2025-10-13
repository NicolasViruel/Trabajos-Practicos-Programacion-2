package ecommerce.model;


import ecommerce.billing.Pagable;
import ecommerce.notify.Notificable;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Un pedido es una colección de productos. Implementa Pagable
 * sumando el total de todos los productos.
 */
public class Pedido implements Pagable {
    public enum Estado { CREADO, PAGADO, EN_PREPARACION, ENVIADO, ENTREGADO, CANCELADO }


    private final List<Producto> productos = new ArrayList<>();
    private final List<Notificable> suscriptores = new ArrayList<>();
    private Estado estado = Estado.CREADO;


    public void agregar(Producto p) {
        if (p == null) throw new IllegalArgumentException("Producto nulo");
        productos.add(p);
    }


    public boolean eliminar(Producto p) { return productos.remove(p); }


    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos); // Evitar modificaciones externas
    }


    public Estado getEstado() { return estado; }


    public void setEstado(Estado nuevo) {
        if (nuevo == null) return;
        this.estado = nuevo;
        notificarATodos("El pedido cambió de estado a: " + nuevo);
    }


    public void suscribir(Notificable n) {
        if (n != null && !suscriptores.contains(n)) suscriptores.add(n);
    }


    public void desuscribir(Notificable n) { suscriptores.remove(n); }


    private void notificarATodos(String mensaje) {
        for (Notificable n : suscriptores) {
            n.notificar(mensaje);
        }
    }


    @Override
    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}