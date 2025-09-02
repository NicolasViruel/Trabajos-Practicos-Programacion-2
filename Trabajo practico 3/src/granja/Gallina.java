package granja;

public class Gallina {
    // Atributos
    int idGallina;
    int edad;
    int huevosPuestos;

    // Constructor
    public Gallina(int idGallina, int edadInicial) {
        this.idGallina = idGallina;
        this.edad = edadInicial;
        this.huevosPuestos = 0; // al inicio no puso huevos
    }

    // Métodos
    public void ponerHuevo() {
        huevosPuestos++;
    }

    public void envejecer() {
        edad++;
    }

    public void mostrarEstado() {
        System.out.println("Gallina #" + idGallina +
                " | Edad: " + edad +
                " | Huevos puestos: " + huevosPuestos);
    }
}