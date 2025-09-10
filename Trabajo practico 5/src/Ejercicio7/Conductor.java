package Ejercicio7;

public class Conductor {
    private String nombre;
    private String licencia;
    private Vehiculo vehiculo; // bidireccional
    public Conductor(String nombre, String licencia) { this.nombre = nombre; this.licencia = licencia; }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        if (vehiculo != null && vehiculo.getConductor() != this) vehiculo.setConductor(this);
    }
    public Vehiculo getVehiculo() { return vehiculo; }
    public String getNombre() { return nombre; }
    public String getLicencia() { return licencia; }
}
