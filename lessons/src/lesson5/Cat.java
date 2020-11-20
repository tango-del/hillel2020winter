package lesson5;

public class Cat extends HomeAnimal {
    public Cat() {
    }

    @Override
    protected String makeVoice() {
        return "Hello, my name is " + getName() + " Meow";
    }
}
