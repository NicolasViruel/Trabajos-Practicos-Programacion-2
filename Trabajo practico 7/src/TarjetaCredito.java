import java.math.BigDecimal;

public class TarjetaCredito implements Pagable {
    private final String ultimos4;

    public TarjetaCredito(String ultimos4) { this.ultimos4 = ultimos4; }

    @Override
    public String pagar(BigDecimal monto) {
        return "Pago con Tarjeta ****" + ultimos4 + " por $" + monto;
    }
}
