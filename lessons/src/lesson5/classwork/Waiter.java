package lesson5.classwork;

public class Waiter extends StaffVisitor {
    private short tips; //chaevie

    @Override
    public String interactVisitors() {
        return "Can i take your order?";
    }

    @Override
    public void takeOrder() {
    }


    @Override
    public void acceptTip(short tips) {
        this.tips += tips;
    }

    @Override
    public String presentWorker() {
        return "Hello, my name is " + super.getFirstName() + " and I`m working Waiter";
    }
}
