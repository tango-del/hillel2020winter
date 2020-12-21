package lesson7.Collection;

public interface StringCollection {
    void add(String str);
    void add(int index, String str);
    void remove(String str);
    void remove(int index);
    String get(String str);
    String get(int index);
}
