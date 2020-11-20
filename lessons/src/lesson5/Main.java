package lesson5;

public class Main {
    public static void main(String[] args) {
        GuideDog gd1 = new GuideDog("Doge", true);
        System.out.println(gd1.makeVoice());

        GuideDog gd2 = new GuideDog("Spanky", false);
        System.out.println(gd2.makeVoice());

        Fish fish = new Fish();
        System.out.println(fish.makeVoice());
        System.out.println(fish.move());
    }
}
