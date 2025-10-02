import Ejercicio_1.MainEjercicio1;
import Ejercicio_2.MainEjercicio2;
import Ejercicio_3.MainEjercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elegí ejercicio a ejecutar (1, 2 o 3):");
        String opt = sc.nextLine();

        switch (opt) {
            case "1" -> MainEjercicio1.run();
            case "2" -> MainEjercicio2.run();
            case "3" -> MainEjercicio3.run();
            default -> System.out.println("Opción inválida.");
        }
    }
}