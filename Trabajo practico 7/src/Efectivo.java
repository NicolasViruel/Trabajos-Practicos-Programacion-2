import java.math.BigDecimal;

public class Efectivo implements Pagable {
    @Override
    public String pagar(BigDecimal monto) {
        return "Pago en efectivo por $" + monto;
    }
}