public class ArrayRecursivo {

    // Funcion recursiva para mostrar precios
    public static void mostrarPrecios(double[] precios, int indice) {
        if (indice >= precios.length) {
            return; // Caso base: fin del array
        }
        System.out.println("Precio: $" + precios[indice]);
        mostrarPrecios(precios, indice + 1); // Llamada recursiva
    }

    public static void main(String[] args) {
        // a. Declarar e inicializar el array de precios
        double[] precios = {199.99, 299.50, 149.75, 399.00, 89.99};

        // b. Mostrar precios originales usando recursividad
        System.out.println("Precios originales:");
        mostrarPrecios(precios, 0);

        // c. Modificar el precio del producto en índice 2 (tercer producto)
        precios[2] = 129.99;

        // d. Mostrar precios modificados usando recursividad
        System.out.println("\nPrecios modificados:");
        mostrarPrecios(precios, 0);
    }
}
