package lesson8.Collection;

public interface StringCollection<E> {
    boolean add(E str);
    //void add(String str, int index);
    void remove(String str);
    void remove(int index);
    String get(String str);
    String get(int index);
}
