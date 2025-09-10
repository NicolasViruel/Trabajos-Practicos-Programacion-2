package Ejercicio1;

// Composicion: Pasaporte → Foto
public class Pasaporte {
    private String numero;
    private String fechaEmision;
    private final Foto foto; // composición: parte esencial del pasaporte

    // Asociación bidireccional con Titular
    private Titular titular;

    public Pasaporte(String numero, String fechaEmision, Foto foto) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.foto = foto;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
        if (titular != null && titular.getPasaporte() != this) {
            titular.setPasaporte(this);
        }
    }

    public Titular getTitular() { return titular; }
    public String getNumero() { return numero; }
    public String getFechaEmision() { return fechaEmision; }
    public Foto getFoto() { return foto; }
}