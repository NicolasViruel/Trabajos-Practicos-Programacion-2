import java.math.BigDecimal;

public class Transferencia implements Pagable {
    private final String cbuDestino;

    public Transferencia(String cbuDestino) { this.cbuDestino = cbuDestino; }

    @Override
    public String pagar(BigDecimal monto) {
        return "Transferencia a CBU " + cbuDestino + " por $" + monto;
    }
}
