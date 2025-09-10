package Ejercicio12;

// Dependencia de uso: usa el parametro y NO lo guarda como atributo
public class Calculadora {
    public void calcular(Impuesto impuesto) {
        System.out.println("Calculando impuesto $" + impuesto.getMonto() +
                " para " + impuesto.getContribuyente().getNombre() +
                " (CUIL " + impuesto.getContribuyente().getCuil() + ")");
    }
}
