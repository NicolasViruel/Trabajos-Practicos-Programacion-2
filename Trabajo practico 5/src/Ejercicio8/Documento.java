package Ejercicio8;

public class Documento {
    private String titulo;
    private String contenido;
    private final FirmaDigital firma; // composición: parte esencial del documento

    public Documento(String titulo, String contenido, FirmaDigital firma) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.firma = firma;
    }

    public String getTitulo() { return titulo; }
    public String getContenido() { return contenido; }
    public FirmaDigital getFirma() { return firma; }
}
