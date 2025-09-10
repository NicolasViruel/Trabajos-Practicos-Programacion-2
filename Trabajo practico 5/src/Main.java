import Ejercicio1.Foto;
import Ejercicio1.Pasaporte;
import Ejercicio1.Titular;
import Ejercicio10.ClaveSeguridad;
import Ejercicio10.CuentaBancaria;
import Ejercicio11.Artista;
import Ejercicio11.Cancion;
import Ejercicio11.Reproductor;
import Ejercicio12.Calculadora;
import Ejercicio12.Contribuyente;
import Ejercicio12.Impuesto;
import Ejercicio13.GeneradorQR;
import Ejercicio14.EditorVideo;
import Ejercicio14.Proyecto;
import Ejercicio2.Bateria;
import Ejercicio2.Celular;
import Ejercicio2.Usuario;
import Ejercicio3.Autor;
import Ejercicio3.Editorial;
import Ejercicio3.Libro;
import Ejercicio4.Banco;
import Ejercicio4.Cliente;
import Ejercicio4.TarjetaDeCredito;
import Ejercicio5.Computadora;
import Ejercicio5.PlacaMadre;
import Ejercicio5.Propietario;
import Ejercicio6.Consumidor;
import Ejercicio6.Mesa;
import Ejercicio6.Reserva;
import Ejercicio7.Conductor;
import Ejercicio7.Motor;
import Ejercicio7.Vehiculo;
import Ejercicio8.Documento;
import Ejercicio8.FirmaDigital;
import Ejercicio9.CitaMedica;
import Ejercicio9.Paciente;
import Ejercicio9.Profesional;

public class Main {
    public static void main(String[] args) {

    // --- Punto 1 ---
        System.out.println("\n--- Punto 1: Foto-Titular-Pasaporte ---");

        Foto foto = new Foto("persona1.jpg", "jpg");
        Pasaporte pasaporte = new Pasaporte("AR1234567", "1988-04-06", foto);
        Titular titular = new Titular("Nicolas viruel", "12345678");

        // Vinculamos la asociación bidireccional
        pasaporte.setTitular(titular);

        // Usamoslos getters :
        System.out.println("Imagen: " + pasaporte.getFoto().getImagen());
        System.out.println("DNI: " + titular.getDni());
        System.out.println("Emisión: " + pasaporte.getFechaEmision());
        System.out.println("Titular del pasaporte: " + pasaporte.getTitular().getNombre());
        System.out.println("Pasaporte del titular: " + titular.getPasaporte().getNumero());

    // --- Punto 2 ---
        System.out.println("\n--- Punto 2: Celular-Bateria-Usuario ---");

    Bateria b1 = new Bateria("BT-5000", 5000);
    Celular cel = new Celular("359123456789012", "Samsung", "S24");
    Usuario u = new Usuario("Alejandro viruel", "31587332");

        cel.setBateria(b1);   // agregacion
        cel.setUsuario(u);    // asociacion bidireccional

    // Usamos los getters
        System.out.println("Usuario del celular: " + cel.getUsuario().getNombre());
        System.out.println("Celular del usuario: " + u.getCelular().getMarca() + " " + u.getCelular().getModelo());
        System.out.println("Bateria instalada: " + cel.getBateria().getModelo() + " - " + cel.getBateria().getCapacidad() + "mAh");

    // Cambiamos la bateria (la anterior sigue viviendo)
    Bateria b2 = new Bateria("BT-6000-Pro", 6000);
        cel.setBateria(b2);
        System.out.println("Batería reemplazada: " + cel.getBateria().getModelo() + " - " + cel.getBateria().getCapacidad() + "mAh");
    // b1 sigue existiendo:
        System.out.println("La bateria anterior todavia existe: " + b1.getModelo());

    // --- Punto 3 ---
        System.out.println("\n--- Punto 3: Libro-Autor-Editorial ---");

        Autor autor = new Autor("Julio Cortazar", "Argentina");
        Libro libro = new Libro("Rayuela", "9781234567890", autor);

        Editorial e1 = new Editorial("Alfaguara", "Av. Siempreviva 742");
        libro.setEditorial(e1); // agregacion

        // Usamos getters para validar
        System.out.println("Autor del libro: " + libro.getAutor().getNombre() + " (" + libro.getAutor().getNacionalidad() + ")");
        System.out.println("Título: " + libro.getTitulo() + " - ISBN: " + libro.getIsbn());
        System.out.println("Editorial: " + libro.getEditorial().getNombre());

        // Demostracion de agregacion (reemplazo de editorial)
        Editorial e2 = new Editorial("Penguin Random House", "Calle cualquiera 102");
        libro.setEditorial(e2);
        System.out.println("Nueva editorial del libro: " + libro.getEditorial().getNombre());
        // e1 sigue existiendo fuera del libro
        System.out.println("La editorial anterior sigue existiendo: " + e1.getNombre());

    // --- Punto 4 ---
        System.out.println("\n--- Punto 4: TarjetaDeCredito-Cliente-Banco ---");

        Banco banco1 = new Banco("Banco Nacion", "30-50000019-2");
        TarjetaDeCredito tc = new TarjetaDeCredito("4509 1234 5678 9010", "12/28");
        Cliente cli = new Cliente("Catalina Viruel", "59186753");

        tc.setBanco(banco1);   // agregacion
        tc.setCliente(cli);    // asociación bidireccional

        System.out.println("Cliente de la tarjeta: " + tc.getCliente().getNombre());
        System.out.println("Tarjeta del cliente: " + cli.getTarjeta().getNumero());
        System.out.println("Banco emisor: " + tc.getBanco().getNombre());

// Demostracion de agregacion: reemplazo del banco
        Banco banco2 = new Banco("BBVA", "30-50000017-8");
        tc.setBanco(banco2);
        System.out.println("Banco reemplazado: " + tc.getBanco().getNombre());
        System.out.println("El banco anterior sigue existiendo: " + banco1.getNombre());


    // --- Punto 5 ---
        System.out.println("\n--- Punto 5: Computadora-PlacaMadre-Propietario ---");

        PlacaMadre pm = new PlacaMadre("ASUS PRIME B550M-A", "B550");
        Computadora pc = new Computadora("AMD", "SN-001-ARG", pm);
        Propietario p1 = new Propietario("Mariano Lopez", "40111222");

        pc.setPropietario(p1); // asociacion bidireccional

        System.out.println("Propietario de la PC: " + pc.getPropietario().getNombre());
        System.out.println("PC del propietario: " + p1.getComputadora().getMarca() + " - " + p1.getComputadora().getNumeroSerie());
        System.out.println("Placa madre: " + pc.getPlacaMadre().getModelo() + " (" + pc.getPlacaMadre().getChipset() + ")");

// Demostracion de asociacion bidireccional: cambiar de propietario
        Propietario p2 = new Propietario("Sofia Torres", "40999888");
        pc.setPropietario(p2);
        System.out.println("Nuevo propietario de la PC: " + pc.getPropietario().getNombre());
        System.out.println("La PC asignada al antiguo propietario ahora es: " + (p1.getComputadora() == null ? "ninguna" : p1.getComputadora().getNumeroSerie()));
        System.out.println("La PC del nuevo propietario: " + p2.getComputadora().getNumeroSerie());

    // --- Punto 6 ---
        System.out.println("\n--- Punto 6: Reserva-Cliente-Mesa ---");
        Consumidor c6 = new Consumidor("Laura Diaz", "11-5555-1234");
        Reserva r6 = new Reserva("2025-09-15", "21:30", c6);
        Mesa m61 = new Mesa(7, 4);
        r6.setMesa(m61);
        System.out.println("Cliente de la reserva: " + r6.getConsumidor().getNombre());
        System.out.println("Mesa asignada: " + r6.getMesa().getNumero() + " (cap " + r6.getMesa().getCapacidad() + ")");
        Mesa m62 = new Mesa(12, 6); // agregación: se reemplaza
        r6.setMesa(m62);
        System.out.println("Mesa reemplazada: " + r6.getMesa().getNumero());

    // --- Punto 7 --        -
        System.out.println("\n--- Punto 7: Vehiculo-Motor-Conductor ---");
        Vehiculo v7 = new Vehiculo("ABC123", "Fiesta");
        Motor m7 = new Motor("Nafta 1.6", "MTR-001");
        Conductor cond7 = new Conductor("Diego Perez", "B12345678");
        v7.setMotor(m7);
        v7.setConductor(cond7);
        System.out.println("Conductor del vehiculo: " + v7.getConductor().getNombre());
        System.out.println("Vehiculo del conductor: " + cond7.getVehiculo().getPatente());
        System.out.println("Motor: " + v7.getMotor().getTipo() + " (" + v7.getMotor().getNumeroSerie() + ")");

    // --- Punto 8 --
        System.out.println("\n--- Punto 8: Documento-FirmaDigital-Usuario ---");
        Ejercicio8.Usuario u8 = new Ejercicio8.Usuario("Noelia Mail", "noelia@mail.com");
        FirmaDigital f8 = new FirmaDigital("HASH-001", "2025-09-15");
        f8.setUsuario(u8); // agregacion
        Documento d8 = new Documento("Contrato", "Contenido...", f8); // composicion
        System.out.println("Doc: " + d8.getTitulo());
        System.out.println("Firmado por: " + d8.getFirma().getUsuario().getNombre());
        System.out.println("Hash: " + d8.getFirma().getCodigoHash());

    // --- Punto 9 --
        System.out.println("\n--- Punto 9: CitaMedica-Paciente-Profesional ---");
        Paciente p9 = new Paciente("Mario Soto", "OSDE");
        Profesional prof9 = new Profesional("Dra. Ruiz", "Cardiologia");
        CitaMedica cita9 = new CitaMedica("2025-10-01", "10:00", p9, prof9);
        System.out.println("Paciente: " + cita9.getPaciente().getNombre() + " (" + cita9.getPaciente().getObraSocial() + ")");
        System.out.println("Profesional: " + cita9.getProfesional().getNombre() + " - " + cita9.getProfesional().getEspecialidad());
        System.out.println("Turno: " + cita9.getFecha() + " " + cita9.getHora());

    // --- Punto 10 --
        System.out.println("\n--- Punto 10: CuentaBancaria-ClaveSeguridad-Titular ---");
        ClaveSeguridad cs10 = new ClaveSeguridad("1234", "2025-01-01");
        CuentaBancaria cb10 = new CuentaBancaria("0000003100012345678901", 150000.0, cs10);
        Ejercicio10.Titular t10 = new Ejercicio10.Titular("Valeria L.", "30111222");
        cb10.setTitular(t10);

        System.out.println("Titular de la cuenta: " + cb10.getTitular().getNombre());
        System.out.println("Cuenta del titular: " + t10.getCuenta().getCbu());
        System.out.println("Clave (comp): " + cb10.getClave().getCodigo());

    // --- Punto 11 --
        System.out.println("\n--- Punto 11: Reproductor-Cancion-Artista (dependencia de uso) ---");
        Artista ar11 = new Artista("Soda Stereo", "Rock");
        Cancion ca11 = new Cancion("De Música Ligera", ar11);
        new Reproductor().reproducir(ca11);

    // --- Punto 12 --
        System.out.println("\n--- Punto 12: Impuesto-Contribuyente-Calculadora (uso) ---");
        Contribuyente cont12 = new Contribuyente("Romi Vega", "27-12345678-9");
        Impuesto imp12 = new Impuesto(12345.67, cont12);
        new Calculadora().calcular(imp12);


    // --- Punto 13 --
        System.out.println("\n--- Punto 13: GeneradorQR-Usuario-CodigoQR (creacion) ---");
        new GeneradorQR().generar("ABC-123-XYZ", new Ejercicio13.Persona("Facundo", "facundo@mail.com"));


    // --- Punto 14 --
        System.out.println("\n--- Punto 14: EditorVideo-Proyecto-Render (creacion) ---");
        new EditorVideo().exportar("mp4", new Proyecto("Intro del Curso", 120));

    }
}