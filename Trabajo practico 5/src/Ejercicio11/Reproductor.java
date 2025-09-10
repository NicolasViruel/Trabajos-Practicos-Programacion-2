package Ejercicio11;

// Dependencia de uso: usa el parametro y NO lo guarda
public class Reproductor {
    public void reproducir(Cancion cancion) {
        System.out.println("Reproduciendo: " + cancion.getTitulo()
                + " - " + cancion.getArtista().getNombre());
    }
}
