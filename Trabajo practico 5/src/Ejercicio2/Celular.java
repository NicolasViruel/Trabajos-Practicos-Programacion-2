package Ejercicio2;

// Agregacion: Celular → Bateria
public class Celular {
    private String imei;
    private String marca;
    private String modelo;
    private Bateria bateria;   // puede existir independiente

    // Asociacion bidireccional con Usuario
    private Usuario usuario;

    public Celular(String imei, String marca, String modelo) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
    }

    // Agregacion: se puede cambiar la bateria
    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }

    // Bidireccional: sincroniza el otro lado
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        if (usuario != null && usuario.getCelular() != this) {
            usuario.setCelular(this);
        }
    }

    public Usuario getUsuario() { return usuario; }
    public Bateria getBateria() { return bateria; }
    public String getImei() { return imei; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
}
