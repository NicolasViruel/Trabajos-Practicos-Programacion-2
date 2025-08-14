import java.util.Scanner;

public class SumaPares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int suma = 0;

        while (true) {
            System.out.print("Ingrese un número (0 para terminar): ");
            numero = sc.nextInt();

            if (numero == 0) {
                break;
            }

            if (numero % 2 == 0) {
                suma += numero;
            }
        }

        System.out.println("La suma de los números pares es: " + suma);

        sc.close();
    }
}
