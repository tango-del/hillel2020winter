package lesson5;

public class HomeAnimal extends Animal {
    public HomeAnimal() {
    }
    private String name;
    private boolean vaccinated;

    @Override
    protected String makeVoice() {
        return "Hello, my name is " + name;
    }


    public boolean isVaccinated(boolean vaccinated) {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
