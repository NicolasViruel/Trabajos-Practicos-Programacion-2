package nave;

public class NaveEspacial {
    // Atributos
    String nombre;
    int combustible;
    int capacidadMax = 100; // límite de combustible
    boolean enVuelo = false;

    // Constructor
    public NaveEspacial(String nombre, int combustibleInicial) {
        this.nombre = nombre;
        if (combustibleInicial > capacidadMax) {
            this.combustible = capacidadMax;
        } else if (combustibleInicial < 0) {
            this.combustible = 0;
        } else {
            this.combustible = combustibleInicial;
        }
    }

    // Métodos
    public void despegar() {
        if (combustible > 0) {
            enVuelo = true;
            System.out.println(nombre + " ha despegado 🚀");
        } else {
            System.out.println("No hay combustible para despegar.");
        }
    }

    public void avanzar(int distancia) {
        int consumo = distancia; // 1 unidad de combustible por 1 unidad de distancia
        if (combustible >= consumo) {
            combustible -= consumo;
            System.out.println(nombre + " avanzo " + distancia + " km.");
        } else {
            System.out.println("⚠️ Combustible insuficiente para avanzar " + distancia + " km.");
        }
    }

    public void recargarCombustible(int cantidad) {
        if (cantidad > 0) {
            combustible += cantidad;
            if (combustible > capacidadMax) {
                combustible = capacidadMax;
            }
            System.out.println(nombre + " recargo combustible. Nivel actual: " + combustible);
        }
    }

    public void mostrarEstado() {
        System.out.println("Nave: " + nombre +
                " | Combustible: " + combustible + "/" + capacidadMax +
                " | En vuelo: " + (enVuelo ? "Si" : "No"));
    }
}