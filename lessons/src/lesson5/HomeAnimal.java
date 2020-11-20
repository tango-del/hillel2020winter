package lesson5;

public class HomeAnimal extends Animal {
    public HomeAnimal() {
    }
    private String name;
    private boolean Vaccinated;

    @Override
    protected String makeVoice() {
        return "Hello, my name is " + name;
    }


    public boolean isVaccinated(boolean vaccinated) {
        return Vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        Vaccinated = vaccinated;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
