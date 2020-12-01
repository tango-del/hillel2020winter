package lesson7Test.Collection;

public interface StringCollection {
    void add(String str);
    void add(String str, int index);
    void remove(String str);
    void remove(int index);
    String get(String str);
    String get(int index);
}
