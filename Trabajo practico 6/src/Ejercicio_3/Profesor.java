package Ejercicio_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Profesor {
    private final String id;
    private String nombre;
    private String especialidad;
    private final List<Curso> cursos = new ArrayList<>();

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    /** Agrega el curso y sincroniza el otro lado. */
    public void agregarCurso(Curso c) {
        if (c == null) return;
        if (!cursos.contains(c)) cursos.add(c);
        if (c.getProfesor() != this) c.setProfesor(this); // sincroniza
    }

    /** Quita el curso y sincroniza el otro lado. */
    public void eliminarCurso(Curso c) {
        if (c == null) return;
        cursos.remove(c);
        if (c.getProfesor() == this) c.setProfesor(null); // sincroniza
    }

    /** Solo lectura para no exponer la lista interna. */
    public List<Curso> getCursos() { return Collections.unmodifiableList(cursos); }

    /** Uso interno desde Curso.setProfesor(...) para evitar recursión. */
    void addCursoDesdeCurso(Curso c) {
        if (!cursos.contains(c)) cursos.add(c);
    }

    /** Uso interno desde Curso.setProfesor(...) para evitar recursión. */
    void removeCursoDesdeCurso(Curso c) {
        cursos.remove(c);
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("    (sin cursos asignados)");
            return;
        }
        for (Curso c : cursos) {
            System.out.println("    - " + c.getCodigo() + " | " + c.getNombre());
        }
    }

    public void mostrarInfo() {
        System.out.printf("Profesor [%s] %s - %s | Cursos: %d%n",
                id, nombre, especialidad, cursos.size());
    }

    @Override
    public String toString() {
        return nombre + " (" + especialidad + ")";
    }
}
