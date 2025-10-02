import java.math.BigDecimal;

public abstract class Empleado {
    private final String nombre;

    public Empleado(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }

    public abstract BigDecimal calcularSueldo();
}