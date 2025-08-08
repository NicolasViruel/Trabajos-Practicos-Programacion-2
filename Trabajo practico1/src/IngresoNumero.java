import java.util.Scanner;

public class IngresoNumero {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primero numero: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingrese el segundo numero: ");
        int num2 = scanner.nextInt();

        int suma = num1 + num2;
        int resta = num1 - num2;
        int multiplicacion = num1 * num2;
        double division = (double) num1 / num2;

        System.out.print("Suma: " + suma);
        System.out.print(" Resta: " + resta);
        System.out.print(" Multiplicacion: " + multiplicacion);
        System.out.print(" Division: " + division);

        scanner.close();
    }
}
