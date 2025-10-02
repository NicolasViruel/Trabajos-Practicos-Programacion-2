package Ejercicio_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Universidad {
    private final String nombre;
    private final List<Profesor> profesores = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();

    public Universidad(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }

    public boolean agregarProfesor(Profesor p) {
        if (p == null) return false;
        if (buscarProfesorPorId(p.getId()).isPresent()) return false;
        return profesores.add(p);
    }

    public boolean agregarCurso(Curso c) {
        if (c == null) return false;
        if (buscarCursoPorCodigo(c.getCodigo()).isPresent()) return false;
        return cursos.add(c);
    }

    public Optional<Profesor> buscarProfesorPorId(String id) {
        for (Profesor p : profesores) if (p.getId().equalsIgnoreCase(id)) return Optional.of(p);
        return Optional.empty();
    }

    public Optional<Curso> buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) if (c.getCodigo().equalsIgnoreCase(codigo)) return Optional.of(c);
        return Optional.empty();
    }

    public boolean asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Optional<Curso> oc = buscarCursoPorCodigo(codigoCurso);
        Optional<Profesor> op = buscarProfesorPorId(idProfesor);
        if (oc.isEmpty() || op.isEmpty()) return false;
        oc.get().setProfesor(op.get()); // setProfesor mantiene ambos lados
        return true;
    }

    public void listarProfesores() {
        if (profesores.isEmpty()) { System.out.println("No hay profesores."); return; }
        for (Profesor p : profesores) {
            p.mostrarInfo();
            p.listarCursos();
        }
    }

    public void listarCursos() {
        if (cursos.isEmpty()) { System.out.println("No hay cursos."); return; }
        for (Curso c : cursos) c.mostrarInfo();
    }

    public boolean eliminarCurso(String codigo) {
        Iterator<Curso> it = cursos.iterator();
        while (it.hasNext()) {
            Curso c = it.next();
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                // Romper relación con su profesor (si existe)
                if (c.getProfesor() != null) c.setProfesor(null);
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean eliminarProfesor(String id) {
        Iterator<Profesor> it = profesores.iterator();
        while (it.hasNext()) {
            Profesor p = it.next();
            if (p.getId().equalsIgnoreCase(id)) {
                // Dejar profesor = null en todos los cursos que dictaba
                // Hacemos copia para evitar ConcurrentModification
                List<Curso> copia = new ArrayList<>(p.getCursos());
                for (Curso c : copia) c.setProfesor(null);
                it.remove();
                return true;
            }
        }
        return false;
    }

    public List<Profesor> getProfesores() { return Collections.unmodifiableList(profesores); }
    public List<Curso> getCursos() { return Collections.unmodifiableList(cursos); }
}

