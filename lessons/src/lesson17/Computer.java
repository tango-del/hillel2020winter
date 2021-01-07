package lesson17;

public class Computer extends Player {
    @Override
    public String toString() {
        return "Computer{" +
                "signs=" + getSigns() +
                '}';
    }
}
