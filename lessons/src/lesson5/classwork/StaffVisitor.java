package lesson5.classwork;

public class StaffVisitor extends Staff {
    private boolean healthBook; //санитар книга
    private String systemCode; //личный номер в системе учета
    private String inventoryControl; //склад учет
    private boolean accessDishes; //доступ к посуде
    private int cashBox;

    public String interactVisitors() {
        return null;
    }

    public void takeOrder() {
    }

    public void acceptPayment(int money) {
        this.cashBox += money;
    }

    public void acceptTip(short tips) {

    }
}
