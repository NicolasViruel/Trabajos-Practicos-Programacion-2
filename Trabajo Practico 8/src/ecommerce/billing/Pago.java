package ecommerce.billing;


/**
 * Medio de pago.
 */
public interface Pago {
    /** Procesa el pago del monto (ya con descuentos/tasas aplicadas). */
    void procesarPago(double monto);
}
