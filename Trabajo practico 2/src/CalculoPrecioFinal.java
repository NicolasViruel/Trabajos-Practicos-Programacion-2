import java.util.Scanner;

public class CalculoPrecioFinal {

    public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
        return precioBase + (precioBase * impuesto) - (precioBase * descuento);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = sc.nextDouble();

        System.out.print("Ingrese el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
        double impuestoPorcentaje = sc.nextDouble() / 100;

        System.out.print("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): ");
        double descuentoPorcentaje = sc.nextDouble() / 100;

        double precioFinal = calcularPrecioFinal(precioBase, impuestoPorcentaje, descuentoPorcentaje);

        System.out.println("El precio final del producto es: " + precioFinal);

        sc.close();
    }
}
