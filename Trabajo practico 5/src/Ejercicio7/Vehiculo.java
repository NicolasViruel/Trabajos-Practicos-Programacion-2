package Ejercicio7;
// Agregacion: Vehiculo → Motor

public class Vehiculo {
    private String patente;
    private String modelo;
    private Motor motor;          // agregación
    private Conductor conductor;  // bidireccional
    public Vehiculo(String patente, String modelo) { this.patente = patente; this.modelo = modelo; }
    public void setMotor(Motor motor) { this.motor = motor; }
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
        if (conductor != null && conductor.getVehiculo() != this) conductor.setVehiculo(this);
    }
    public Motor getMotor() { return motor; }
    public Conductor getConductor() { return conductor; }
    public String getPatente() { return patente; }
    public String getModelo() { return modelo; }
}
