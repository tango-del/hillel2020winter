package lesson6;

public class HomeAnimal extends Animal {
    public HomeAnimal() {
    }
    private String name;
    private boolean vaccinated;

    @Override
    public String makeVoice() {
        return "Hello, my name is " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVaccinated(boolean vaccinated) {
        return this.vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
