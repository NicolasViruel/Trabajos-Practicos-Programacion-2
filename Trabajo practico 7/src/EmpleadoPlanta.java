import java.math.BigDecimal;

public class EmpleadoPlanta extends Empleado {
    private final BigDecimal sueldoBase;
    private final BigDecimal bono;

    public EmpleadoPlanta(String nombre, BigDecimal sueldoBase, BigDecimal bono) {
        super(nombre);
        this.sueldoBase = sueldoBase;
        this.bono = bono;
    }

    @Override
    public BigDecimal calcularSueldo() {
        return sueldoBase.add(bono);
    }
}