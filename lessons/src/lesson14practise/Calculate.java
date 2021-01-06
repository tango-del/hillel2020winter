package lesson14practise;

public class Calculate {
    public static void main(String[] args) {
        Operation operation = (x) -> {
                int y = x * x;
                return y;
        };
        operation = (x) -> x * x;

        int result = operation.calculate(10);
        System.out.println(operation.calculate(12));
        System.out.println(result);

        Operation operation1 = (x) -> {
            int a = x;
            return a;
        };

        Print print = () -> System.out.println("Test");
        print.print();

    }
}

@FunctionalInterface
interface Operation {
    int calculate(int x);
}

@FunctionalInterface
interface Print {
    void print();
}
