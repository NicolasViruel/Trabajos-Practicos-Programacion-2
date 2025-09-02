package mascota;

public class Mascota {
    // Atributos
    public String nombre;
    public String especie;
    public int edad;

    // Métodos
    public void mostrarInfo() {
        System.out.println("Mascota: " + nombre +
                " | Especie: " + especie +
                " | Edad: " + edad + " años");
    }

    public void cumplirAnios() {
        edad++;
    }
}
