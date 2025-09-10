package Ejercicio4;

// Agregacion: TarjetaDeCredito → Banco
public class TarjetaDeCredito {
    private String numero;
    private String fechaVencimiento;
    private Banco banco; // agregacion

    // Asociacion bidireccional con Cliente
    private Cliente cliente;

    public TarjetaDeCredito(String numero, String fechaVencimiento) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setBanco(Banco banco) { this.banco = banco; }
    public Banco getBanco() { return banco; }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        if (cliente != null && cliente.getTarjeta() != this) {
            cliente.setTarjeta(this);
        }
    }

    public Cliente getCliente() { return cliente; }
    public String getNumero() { return numero; }
    public String getFechaVencimiento() { return fechaVencimiento; }
}

