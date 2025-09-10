package Ejercicio4;

public class Cliente {
    private String nombre;
    private String dni;
    // Asociacion bidireccional con TarjetaDeCredito
    private TarjetaDeCredito tarjeta;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setTarjeta(TarjetaDeCredito tarjeta) {
        this.tarjeta = tarjeta;
        if (tarjeta != null && tarjeta.getCliente() != this) {
            tarjeta.setCliente(this);
        }
    }

    public TarjetaDeCredito getTarjeta() { return tarjeta; }
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
}

