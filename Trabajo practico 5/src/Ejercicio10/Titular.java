package Ejercicio10;

public class Titular {
    private String nombre;
    private String dni;
    private CuentaBancaria cuenta; // bidireccional

    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
        if (cuenta != null && cuenta.getTitular() != this) {
            cuenta.setTitular(this);
        }
    }

    public CuentaBancaria getCuenta() { return cuenta; }
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
}
