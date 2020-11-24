package lesson6;

public class Wild extends AnimalClass {
    public Wild() {
    }

    @Override
    public String makeVoice() {
        return "I am a wild animal";
    }

    private boolean predator;

    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }
}
