package lesson8.Collection;

public interface StringCollection<E> {
    boolean add(Object str);
    void adD(Object str);
    boolean add(Object str, int index);
    void adD(Object str, int index);
    boolean remove(Object str);
    boolean remove(int index);
    Object get(Object str);
    Object get(int index);
    boolean contains(Object str);
}
