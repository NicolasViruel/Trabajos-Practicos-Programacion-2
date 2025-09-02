import estudiante.Estudiante;
import granja.Gallina;
import mascota.Mascota;
import libro.Libro;
import nave.NaveEspacial;

public class Main {
    public static void main(String[] args) {
        // ====== Estudiante ======
        Estudiante e = new Estudiante();
        e.nombre = "Ana";
        e.apellido = "García";
        e.curso = "Programación II";
        e.calificacion = 7.5;

        // Mostrar info inicial
        e.mostrarInfo();

        // Subir calificación
        e.subirCalificacion(2);
        e.mostrarInfo();

        // Bajar calificación
        e.bajarCalificacion(1.5);
        e.mostrarInfo();

        // ====== Mascota ======
        Mascota m = new Mascota();
        m.nombre = "Candy";
        m.especie = "Perro";
        m.edad = 3;

        // Mostrar info inicial
        m.mostrarInfo();

        // Simular paso del tiempo
        m.cumplirAnios();
        m.mostrarInfo();

        // ====== Libro ======
        Libro l = new Libro("El Principito", "Antoine de Saint-Exupery", 1943);
        l.mostrarInfo();

        // Intentar modificar con un año invalido
        l.setAnioPublicacion(3000);

        // Modificar con un año váaido
        l.setAnioPublicacion(1998);

        // Mostrar info final
        l.mostrarInfo();

        // ====== Gallinas ======
        Gallina g1 = new Gallina(1, 2); // gallina 1 con 2 años
        Gallina g2 = new Gallina(2, 1); // gallina 2 con 1 año

        // Simular acciones
        g1.envejecer();     // g1 cumple un año
        g1.ponerHuevo();
        g1.ponerHuevo();    // g1 pone 2 huevos

        g2.ponerHuevo();    // g2 pone 1 huevo

        // Mostrar estado
        g1.mostrarEstado();
        g2.mostrarEstado();

        // ====== Nave Espacial ======
        NaveEspacial nave = new NaveEspacial("NaveApolo", 50);

        nave.despegar();// despega
        nave.mostrarEstado();// estado inicial

        nave.avanzar(60);// intentar avanzar sin suficiente combustible

        nave.recargarCombustible(40); // recargar combustible
        nave.avanzar(30);

        nave.mostrarEstado();// estado final
    }
}