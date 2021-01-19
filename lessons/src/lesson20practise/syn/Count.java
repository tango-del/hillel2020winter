package lesson20practise.syn;

public class Count {
    private static int count = 100;

    public static void setCount(int count) {
        Count.count = count;
    }

    public static void increment(int amount) { count += amount; }
    public static void decrement(int amount) { count -= amount; }

    public static int getCount() {
        return count;
    }
}
