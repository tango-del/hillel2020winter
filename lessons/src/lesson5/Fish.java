package lesson5;

public class Fish extends HomeAnimal {
    public Fish() {
    }

    @Override
    public String makeVoice() {
        return "...";
    }

    @Override
    protected String move() {
        return "Dude... I`m fish, i can only swim";
    }
}
