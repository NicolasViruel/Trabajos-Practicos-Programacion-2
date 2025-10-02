import java.math.BigDecimal;

public class EmpleadoTemporal extends Empleado {
    private final BigDecimal valorHora;
    private final int horasTrabajadas;

    public EmpleadoTemporal(String nombre, BigDecimal valorHora, int horasTrabajadas) {
        super(nombre);
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public BigDecimal calcularSueldo() {
        return valorHora.multiply(BigDecimal.valueOf(horasTrabajadas));
    }
}