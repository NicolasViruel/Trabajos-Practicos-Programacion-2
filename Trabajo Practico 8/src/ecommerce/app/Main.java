package ecommerce.app;

import ecommerce.model.Cliente;
import ecommerce.model.Pedido;
import ecommerce.model.Producto;
import ecommerce.payment.PayPal;
import ecommerce.util.ComparadoresProducto;
import ecommerce.util.Repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Productos
        Producto p1 = new Producto("Mouse", 5_000);
        Producto p2 = new Producto("Teclado", 12_000);
        Producto p3 = new Producto("Monitor", 95_000);
        Producto p4 = new Producto("Auriculares", 18_000);

        Pedido pedido = new Pedido();
        pedido.agregar(p1);
        pedido.agregar(p2);
        pedido.agregar(p3);
        pedido.agregar(p4);

        System.out.println("Productos: " + pedido.getProductos());
        double total = pedido.calcularTotal();
        System.out.println("Total sin descuentos: $" + total);

        // Ordenamientos
        List<Producto> ordenables = new ArrayList<>(pedido.getProductos());
        Collections.sort(ordenables); // Comparable (nombre, luego precio)
        System.out.println("Orden natural (nombre): " + ordenables);

        ordenables.sort(ComparadoresProducto.POR_PRECIO_ASC);
        System.out.println("Por precio ASC: " + ordenables);

        ordenables.sort(ComparadoresProducto.POR_PRECIO_DESC);
        System.out.println("Por precio DESC: " + ordenables);

        // Repositorio genérico + comodines
        Repositorio<Producto> repo = new Repositorio<>();
        repo.add(p1); repo.add(p2); repo.add(p3); repo.add(p4);

        List<Producto> caros = repo.findAll(p -> p.getPrecio() >= 20_000);
        System.out.println("Caros (>=20k): " + caros);
        System.out.println("Total repositorio: $" + Repositorio.totalDeTodos(repo.getAll()));

        List<Object> bolsa = new ArrayList<>();
        Repositorio.copiar(repo.getAll(), bolsa); // <? extends / ? super>
        System.out.println("Bolsa (Object) luego de copiar productos: tamaño=" + bolsa.size());

        // Notificaciones + pago
        Cliente cliente = new Cliente("Ana", "ana@mail.com");
        pedido.suscribir(cliente);
        pedido.setEstado(Pedido.Estado.EN_PREPARACION);

        PayPal paypal = new PayPal("ana@paypal");
        double totalConDesc = paypal.aplicarDescuento(total);
        System.out.println("Total con descuento (PayPal): " + String.format("%.2f", totalConDesc));
        paypal.procesarPago(totalConDesc);
        pedido.setEstado(Pedido.Estado.PAGADO);
    }
}