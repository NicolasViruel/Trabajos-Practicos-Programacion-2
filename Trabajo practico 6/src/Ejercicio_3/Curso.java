package Ejercicio_3;

public class Curso {
    private final String codigo;
    private String nombre;
    private Profesor profesor; // puede ser null

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Profesor getProfesor() { return profesor; }

    /** Mantiene el invariante de asociación desde ambos lados. */
    public void setProfesor(Profesor nuevo) {
        if (this.profesor == nuevo) return; // no-op si no cambia

        // 1) Desvincular del profesor anterior
        Profesor anterior = this.profesor;
        this.profesor = null; // asignamos primero para evitar loops
        if (anterior != null) {
            anterior.removeCursoDesdeCurso(this);
        }

        // 2) Vincular al nuevo profesor
        this.profesor = nuevo;
        if (nuevo != null) {
            nuevo.addCursoDesdeCurso(this);
        }
    }

    public void mostrarInfo() {
        String prof = (profesor == null) ? "(sin profesor)" : profesor.getNombre();
        System.out.printf("Curso [%s] %s | Profesor: %s%n", codigo, nombre, prof);
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
