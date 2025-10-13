package ecommerce.billing;


/**
 * Permite aplicar un descuento antes de procesar el pago.
 */
public interface PagoConDescuento {
    /** Devuelve el monto con descuento aplicado. */
    double aplicarDescuento(double monto);
}
