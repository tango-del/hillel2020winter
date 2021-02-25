public class Test {

    private long time = System.nanoTime();

    void print() {
        System.out.println("class:Test, method:print() >>>>> " + time);
        System.out.println(hashCode());
    }

    void init() {
        System.out.println("class:Test, method:init()");
    }
}
