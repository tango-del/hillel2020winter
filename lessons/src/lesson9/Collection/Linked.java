package lesson9.Collection;

public interface Linked {
    boolean add(String str);
    int size();
    String get(int index);
    boolean delete (int index);
    boolean delete (String str);
    boolean addAll(String[] strArr);
    boolean addAll(LinkedString strColl);
    boolean clear();
    boolean contains(String str);
    boolean trim();
    boolean compare(LinkedString coll);
}
