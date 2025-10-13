package ecommerce.model;


import ecommerce.notify.Notificable;


public class Cliente implements Notificable {
    private final String nombre;
    private final String email;


    public Cliente(String nombre, String email) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre vacío");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email vacío");
        this.nombre = nombre;
        this.email = email;
    }


    public String getNombre() { return nombre; }
    public String getEmail() { return email; }


    @Override
    public void notificar(String mensaje) {
// Por ahora, solo mostramos por consola.
        System.out.println("[Notificación a " + nombre + "] " + mensaje);
    }
}