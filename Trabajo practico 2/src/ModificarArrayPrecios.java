public class ModificarArrayPrecios {
    public static void main(String[] args) {

        // a. Declarar e inicializar el array de precios
        double[] precios = {199.99, 299.50, 149.75, 399.00, 89.99};

        // b. Mostrar valores originales
        System.out.println("Precios originales:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }

        // c. Modificar el precio del producto en indice 2 (tercer producto)
        precios[2] = 129.99;

        // d. Mostrar valores modificados
        System.out.println("\nPrecios modificados:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }
    }
}
