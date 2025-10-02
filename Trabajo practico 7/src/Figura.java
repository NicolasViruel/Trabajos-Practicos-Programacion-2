public abstract class Figura {
    private final String nombre;

    public Figura(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }

    public abstract double calcularArea();
}