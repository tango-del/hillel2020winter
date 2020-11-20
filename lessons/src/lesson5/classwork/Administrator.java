package lesson5.classwork;

public class Administrator extends StaffVisitor {
    private int totalMoney;

    @Override
    public String presentWorker() {
        return "Hello, my name is " + super.getFirstName() + " and I`m working Administrator";
    }
}
