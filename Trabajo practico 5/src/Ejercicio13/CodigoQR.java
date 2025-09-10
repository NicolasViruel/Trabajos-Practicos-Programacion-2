package Ejercicio13;

// Asociacion unidireccional: CodigoQR → Usuario
public class CodigoQR {
    private String valor;
    private Persona persona;

    public CodigoQR(String valor, Persona persona) {
        this.valor = valor;
        this.persona = persona;
    }

    public String getValor() { return valor; }
    public Persona getUsuario() { return persona; }
}
