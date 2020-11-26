package lesson7;

public interface makeString {
    default void addSymbol(String str) {
        System.out.println(str);
    }
}
