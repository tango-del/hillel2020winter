package lesson9test;

public class Entry {
    private String value;
    private Entry left;
    private Entry right;

    public Entry(String value) {
        this.value = value;
    }

    public void setLeft(Entry left) {
        this.left = left;
    }

    public void setRight(Entry right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public Entry getRight() {
        return right;
    }
}
