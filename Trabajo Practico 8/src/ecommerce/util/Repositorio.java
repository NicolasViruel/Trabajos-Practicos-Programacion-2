package ecommerce.util;


import ecommerce.billing.Pagable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Repositorio genérico de elementos Pagable.
 * Demuestra <T extends Pagable>, comodines ? extends / ? super, y Predicate<? super T>.
 */
public class Repositorio<T extends Pagable> {
    private final List<T> data = new ArrayList<>();


    public void add(T t) { if (t != null) data.add(t); }
    public boolean remove(T t) { return data.remove(t); }
    public List<T> getAll() { return List.copyOf(data); }


    // total de cualquier lista de Pagable o sus subtipos
    public static double totalDeTodos(List<? extends Pagable> items) {
        return items.stream().mapToDouble(Pagable::calcularTotal).sum();
    }


    // Copiar de una fuente de T o subtipo hacia un destino de T o supertipo
    public static <T> void copiar(List<? extends T> src, List<? super T> dst) {
        dst.addAll(src);
    }


    public List<T> findAll(Predicate<? super T> filtro) {
        return data.stream().filter(filtro).collect(Collectors.toUnmodifiableList());
    }
}