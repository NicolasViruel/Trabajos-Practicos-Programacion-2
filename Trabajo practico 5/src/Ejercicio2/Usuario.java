package Ejercicio2;

public class Usuario {
    private String nombre;
    private String dni;
    // Asociacion bidireccional con Celular
    private Celular celular;

    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
        if (celular != null && celular.getUsuario() != this) {
            celular.setUsuario(this);
        }
    }

    public Celular getCelular() { return celular; }
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
}

