package lesson5.classwork;

public class Barmen extends StaffVisitor {
    private short tips; //chaevie
    private String accessBar;

    @Override
    public String interactVisitors() {
        return "Can i take your order?";
    }

    @Override
    public void takeOrder() {
    }

    @Override
    public String presentWorker() {
        return "Hello, my name is " + super.getFirstName() + " and I`m working Barmen";
    }


    @Override
    public void acceptTip(short tips) {
        this.tips += tips;
    }
}
