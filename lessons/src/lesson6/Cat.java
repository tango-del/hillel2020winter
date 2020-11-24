package lesson6;

public class Cat extends HomeAnimal {
    public Cat() {
    }

    @Override
    public String makeVoice() {
        return "Hello, my name is " + getName() + " Meow";
    }
}
