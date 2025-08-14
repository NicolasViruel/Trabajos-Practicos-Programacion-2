import java.util.Scanner;

public class CalculadoraDescuento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();

        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        char categoria = sc.next().toUpperCase().charAt(0);

        double descuento = 0;

        switch (categoria) {
            case 'A':
                descuento = 0.10;
                break;
            case 'B':
                descuento = 0.15;
                break;
            case 'C':
                descuento = 0.20;
                break;
            default:
                System.out.println("Categoría inválida.");
                sc.close();
                return;
        }

        double montoDescuento = precio * descuento;
        double precioFinal = precio - montoDescuento;

        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
        System.out.println("Precio final: " + precioFinal);

        sc.close();
    }
}

