package Ejercicio1;

public class Foto {
    private String imagen;   // ruta o base64
    private String formato;  // jpg, png...

    public Foto(String imagen, String formato) {
        this.imagen = imagen;
        this.formato = formato;
    }

    public String getImagen() { return imagen; }
    public String getFormato() { return formato; }
}
