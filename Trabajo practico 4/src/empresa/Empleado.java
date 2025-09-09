package empresa;

public class Empleado {
    // Atributos
    private int id;
    private String nombre;
    private String puesto;
    private double salario;

    // Atributos estaticos
    private static int totalEmpleados = 0; // contador global
    private static int secuenciaId = 1; // para IDs automaticos
    private static final double SALARIO_POR_DEFECTO = 100000.0;

    // Constructor completo
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;                // uso de this para distinguir atributo vs parametro
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;

        totalEmpleados++;

        // Si me pasan un id alto, aseguro que los IDs automaticos sigan desde ahi
        if (id >= secuenciaId) {
            secuenciaId = id + 1;
        }
    }

    // Constructor con nombre y puesto (ID automatico y salario por defecto)
    public Empleado(String nombre, String puesto) {
        this.id = secuenciaId++;     // ID automático
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = SALARIO_POR_DEFECTO;

        totalEmpleados++;
    }

    // Metodos sobrecargados actualizarSalario:
    // 1) Por porcentaje (ej: 10 => +10%)
    public void actualizarSalario(double porcentaje) {
        this.salario += this.salario * (porcentaje / 100.0);
    }

    // 2) Por cantidad fija
    public void actualizarSalario(int cantidadFija) {
        this.salario += cantidadFija;
    }

    // toString legible
    @Override
    public String toString() {
        return String.format("Empleado{id=%d, nombre='%s', puesto='%s', salario=%.2f}",
                id, nombre, puesto, salario);
    }

    // Metodo para ver total de empleados
    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }

    // Getters & Setters (encapsulamiento)
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setSalario(double salario) {
        if (salario < 0) throw new IllegalArgumentException("El salario no puede ser negativo");
        this.salario = salario;
    }
}
