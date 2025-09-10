package Ejercicio10;

// Composicion: CuentaBancaria → ClaveSeguridad
public class CuentaBancaria {
    private String cbu;
    private double saldo;
    private final ClaveSeguridad clave; // composicion
    private Titular titular;            // bidireccional

    public CuentaBancaria(String cbu, double saldo, ClaveSeguridad clave) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.clave = clave;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
        if (titular != null && titular.getCuenta() != this) {
            titular.setCuenta(this);
        }
    }

    public String getCbu() { return cbu; }
    public double getSaldo() { return saldo; }
    public ClaveSeguridad getClave() { return clave; }
    public Titular getTitular() { return titular; }
}
