package Collection;

public interface StringCollection {
    boolean add(Object str);
    boolean add(Object str, int index);
    boolean remove(Object str);
    boolean remove(int index);
    //int get(Object str);
    Object get(int index);
    boolean contains(Object str);
    boolean contains(StringList temp , Object str);
    boolean clear();
    int size();
}
