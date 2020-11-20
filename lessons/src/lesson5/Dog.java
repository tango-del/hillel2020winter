package lesson5;

public class Dog extends HomeAnimal {
    public Dog(String name, boolean vaccinated) {
        this.setName(name);
        this.isVaccinated(vaccinated);
    }

    public Dog() {
    }

    @Override
    protected String makeVoice() {
        return "Hello, my name is " + getName() + " Woof";
    }
}
