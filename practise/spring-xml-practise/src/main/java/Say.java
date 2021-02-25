public class Say {

    private Long date;

    public Say() {
        this.date = System.currentTimeMillis() / 1000;
    }

    void init() {
        System.out.println(this.getClass().getName() + " >>> init");
    }

    void destroy() {
        System.out.println("destroy");
    }

    void say() {
        System.out.println("Hello .... " + date);
    }
}
