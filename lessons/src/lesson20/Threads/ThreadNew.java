package lesson20.Threads;

import lesson20.Main;
import lesson20.UserCard;

public class ThreadNew extends Thread {
    UserCard userCard;

    public ThreadNew(UserCard userCard) {
        this.userCard = userCard;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int tempRemove = Main.valueRandomizer();

            try {
                userCard.withdrawMoney(tempRemove);
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " thread end. Value -> " + userCard.getMoneyAmount());
    }
}
