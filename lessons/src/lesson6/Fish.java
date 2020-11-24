package lesson6;

public class Fish extends HomeAnimal {
    public Fish() {
    }

    @Override
    public String makeVoice() {
        return "...";
    }

    @Override
    public String move() {
        return "Dude... I`m fish, i can only swim";
    }
}
