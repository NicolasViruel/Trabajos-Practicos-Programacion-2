package ecommerce.app;


import ecommerce.excepciones.EdadInvalidaException;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class MainExcepciones {
    public static void main(String[] args) {
        divisionSegura();
        parseEntero();
        lecturaArchivoSimple();
        try {
            validarEdad(130); // dispara excepción personalizada
        } catch (EdadInvalidaException e) {
            System.out.println("[Edad inválida] " + e.getMessage());
        }
        lecturaConTryWithResources();
    }


    // 1) División segura
    static void divisionSegura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- División segura ---");
        System.out.print("Ingrese dividendo: ");
        int a = leerEnteroDeScanner(sc);
        System.out.print("Ingrese divisor: ");
        int b = leerEnteroDeScanner(sc);
        try {
            int r = a / b; // puede lanzar ArithmeticException si b==0
            System.out.println("Resultado: " + r);
        } catch (ArithmeticException ex) {
            System.out.println("Error: división por cero no permitida.");
        }
    }

    // 2) Conversión String -> int
    static void parseEntero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Conversión de cadena a número ---");
        System.out.print("Ingrese un número entero: ");
        String texto = sc.nextLine();
        try {
            int valor = Integer.parseInt(texto);
            System.out.println("Ok, valor = " + valor);
        } catch (NumberFormatException ex) {
            System.out.println("Error: '" + texto + "' no es un entero válido.");
        }
    }


    // 3) Lectura de archivo con manejo de FileNotFoundException
    static void lecturaArchivoSimple() {
        System.out.println("--- Lectura de archivo simple ---");
        File f = new File("datos.txt"); // cambie el nombre si quiere
        try (FileInputStream fis = new FileInputStream(f)) {
            System.out.println("Archivo encontrado. Bytes disponibles: " + fis.available());
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe: " + f.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error de IO: " + e.getMessage());
        }
    }


    // 4) Excepción personalizada
    static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad " + edad + " no es válida (0-120).");
        }
        System.out.println("Edad válida: " + edad);
    }


    // 5) try-with-resources con BufferedReader
    static void lecturaConTryWithResources() {
        System.out.println("--- Try-with-resources ---");
        Path path = Path.of("datos.txt");
        try {
            if (!Files.exists(path)) {
                Files.writeString(path, "Linea 1\n" +
                        "Linea 2\n" +
                        "Linea 3\n"); // creamos un archivo de ejemplo
            }
        } catch (IOException ignore) {}


        try (BufferedReader br = Files.newBufferedReader(path)) { // se cierra solo
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }


    // Utilidad para leer int sin romper el flujo si el usuario escribe basura
    private static int leerEnteroDeScanner(Scanner sc) {
        while (true) {
            String s = sc.nextLine();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { System.out.print("Ingrese un entero válido: "); }
        }
    }
}