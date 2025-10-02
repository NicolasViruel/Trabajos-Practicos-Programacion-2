import java.math.BigDecimal;

public class Pagos {
    public static <T extends Pagable> String procesarPago(T medio, BigDecimal monto) {
        return medio.pagar(monto);
    }
}