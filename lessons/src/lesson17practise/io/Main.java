package lesson17practise.io;

public class Main {
    public static void main(String[] args) {
        System.out.println(args.length);
        for (String str : args) {
            System.out.println(str);
        }
        System.out.println("111");
        System.err.println("222");
    }
}
