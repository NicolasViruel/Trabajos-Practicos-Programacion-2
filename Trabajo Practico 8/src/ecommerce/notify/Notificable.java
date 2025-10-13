package ecommerce.notify;


/**
 * Contrato para recibir notificaciones de cambios de estado u otros eventos.
 */
public interface Notificable {
    void notificar(String mensaje);
}
