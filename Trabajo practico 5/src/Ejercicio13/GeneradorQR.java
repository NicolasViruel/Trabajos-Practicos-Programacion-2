package Ejercicio13;

// Dependencia de creacion: crea el CodigoQR dentro del metodo y no lo guarda
public class GeneradorQR {
    public void generar(String valor, Persona persona) {
        CodigoQR qr = new CodigoQR(valor, persona);
        System.out.println("QR generado para " + persona.getNombre() + ": " + qr.getValor());
    }
}

