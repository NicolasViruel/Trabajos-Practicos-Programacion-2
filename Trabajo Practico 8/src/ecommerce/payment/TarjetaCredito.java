package ecommerce.payment;


import ecommerce.billing.Pago;
import ecommerce.billing.PagoConDescuento;


public class TarjetaCredito implements Pago, PagoConDescuento {
    private final String numero;
    private final String titular;


    public TarjetaCredito(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }


    @Override
    public double aplicarDescuento(double monto) {
// Ejemplo: 10% de descuento para compras >= 20.000
        if (monto >= 20_000) return monto * 0.90;
        return monto;
    }


    @Override
    public void procesarPago(double monto) {
// Ejemplo: recargo de 3% por uso de tarjeta
        double totalConRecargo = monto * 1.03;
        System.out.println("Pago con Tarjeta de " + titular + " por $" + String.format("%.2f", totalConRecargo));
    }
}