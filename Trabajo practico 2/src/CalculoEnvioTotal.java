import java.util.Scanner;

public class CalculoEnvioTotal {

    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) {
            return peso * 5;
        } else if (zona.equalsIgnoreCase("Internacional")) {
            return peso * 10;
        } else {
            System.out.println("Zona inválida. Se asume costo de envío 0.");
            return 0;
        }
    }

    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el precio del producto: ");
        double precioProducto = sc.nextDouble();

        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = sc.nextDouble();
        sc.nextLine(); // Limpiar buffer

        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = sc.nextLine();

        double costoEnvio = calcularCostoEnvio(peso, zona);
        double total = calcularTotalCompra(precioProducto, costoEnvio);

        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + total);

        sc.close();
    }
}