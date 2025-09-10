package Ejercicio6;

public class Reserva {
    private String fecha;
    private String hora;
    private Consumidor consumidor; // unidireccional
    private Mesa mesa;             // agregación

    public Reserva(String fecha, String hora, Consumidor consumidor) {
        this.fecha = fecha;
        this.hora = hora;
        this.consumidor = consumidor;
    }

    public void setMesa(Mesa mesa) { this.mesa = mesa; }

    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public Consumidor getConsumidor() { return consumidor; }

    public Mesa getMesa() { return mesa; }
}
