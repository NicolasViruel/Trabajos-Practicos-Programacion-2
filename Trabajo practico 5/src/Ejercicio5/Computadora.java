package Ejercicio5;

// Composicion: Computadora → PlacaMadre
public class Computadora {
    private String marca;
    private String numeroSerie;
    private final PlacaMadre placaMadre; // composicion: parte esencial y final

    // Asociacion bidireccional con Propietario
    private Propietario propietario;

    public Computadora(String marca, String numeroSerie, PlacaMadre placaMadre) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.placaMadre = placaMadre;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
        if (propietario != null && propietario.getComputadora() != this) {
            propietario.setComputadora(this);
        }
    }

    public Propietario getPropietario() { return propietario; }
    public String getMarca() { return marca; }
    public String getNumeroSerie() { return numeroSerie; }
    public PlacaMadre getPlacaMadre() { return placaMadre; }
}

