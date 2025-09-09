package empresa;

public class AppEmpleados {
    public static void main(String[] args) {
        System.out.println("=== TP4 - Gestion de Empleados ===");

        // (1) Constructores sobrecargados
        Empleado e1 = new Empleado(100, "Ana Gomez", "Desarrolladora", 350000.0);
        Empleado e2 = new Empleado(101, "Luis Perez", "QA", 280000.0);
        Empleado e3 = new Empleado("Maria Lopez", "UX");
        Empleado e4 = new Empleado("Nicolas Viruel", "DevOps");

        // (2) Sobrecarga de actualizarSalario()
        //    - por porcentaje (double)
        e1.actualizarSalario(10.0);   // +10% → 385000
        e3.actualizarSalario(5.5);    // +5.5% → 105500 (si salario por defecto = 100000)

        //    - por cantidad fija (int)
        e2.actualizarSalario(20000);  // +$20.000 → 300000
        e4.actualizarSalario(15000);  // +$15.000 → 115000

        // (3) Encapsulamiento: getters/setters
        // cambiamos un dato por setter y leemos con getter
        e3.setPuesto("UX Researcher");
        if (!"UX Researcher".equals(e3.getPuesto())) {
            throw new RuntimeException("Fallo de encapsulamiento en set/get de puesto");
        }

        //validacion simple del setter de salario (no negativo)
        try {
            e4.setSalario(-1); // debe lanzar excepcion
            throw new RuntimeException("Se esperaba excepcion por salario negativo y no ocurrio");
        } catch (IllegalArgumentException ex) {
            System.out.println("Excepcion manejada correctamente: " + ex.getMessage());
        }

        // (4) toString
        System.out.println("\n-- Estado de empleados (toString) --");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);

        // (5) Estaticos: totalEmpleados y metodo mostrarTotalEmpleados()
        System.out.println("\nTotal de empleados: " + Empleado.mostrarTotalEmpleados());

        // Comprobacion minima del total (deberia ser 4)
        if (Empleado.mostrarTotalEmpleados() != 4) {
            throw new RuntimeException("El total de empleados deberia ser 4");
        }

        System.out.println("\n✅ Pasaron las verificaciones basicas OK.");
    }
}