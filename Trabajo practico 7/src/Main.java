import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("1) Vehículos y herencia");
        Auto auto = new Auto("Toyota", "Corolla", 4);
        System.out.println(auto.mostrarInfo());

        System.out.println("\n 2) Figuras (polimorfismo) ");
        Figura[] figuras = {
                new Circulo(2.5),
                new Rectangulo(3, 5),
                new Circulo(1)
        };
        for (Figura f : figuras) {
            System.out.println(f.getNombre() + " -> área=" + f.calcularArea());
        }

        System.out.println("\n 3) Empleados (polimorfismo + instanceof) ");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new EmpleadoPlanta("Ana", new BigDecimal("500000"), new BigDecimal("80000")));
        empleados.add(new EmpleadoTemporal("Luis", new BigDecimal("3500"), 120));

        for (Empleado e : empleados) {
            BigDecimal sueldo = e.calcularSueldo();
            String tipo = (e instanceof EmpleadoPlanta) ? "Planta"
                    : (e instanceof EmpleadoTemporal) ? "Temporal"
                    : "Desconocido";
            System.out.println(e.getNombre() + " (" + tipo + ") cobra $" + sueldo);
        }

        System.out.println("\n 4) Animales (override) ");
        List<Animal> animales = List.of(new Perro(), new Gato(), new Vaca());
        for (Animal a : animales) {
            System.out.println(a.describirAnimal() + " Sonido: " + a.hacerSonido());
        }

        System.out.println("\n 5) Pagos (polimorfismo + genéricos)");
        List<Pagable> medios = List.of(
                new TarjetaCredito("1234"),
                new Transferencia("0000003100000000000123"),
                new Efectivo()
        );
        BigDecimal monto = new BigDecimal("19999.99");
        for (Pagable m : medios) {
            String resultado = Pagos.procesarPago(m, monto);
            System.out.println(resultado);
        }
    }
}
