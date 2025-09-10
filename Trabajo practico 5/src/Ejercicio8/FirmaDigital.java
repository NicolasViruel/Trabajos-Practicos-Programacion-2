package Ejercicio8;

public class FirmaDigital {
    private String codigoHash;
    private String fecha;
    private Usuario usuario; // agregación: puede vivir independiente

    public FirmaDigital(String codigoHash, String fecha) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
    }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Usuario getUsuario() { return usuario; }
    public String getCodigoHash() { return codigoHash; }
    public String getFecha() { return fecha; }
}

