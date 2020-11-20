package lesson5;

public class Wild extends Animal {
    public Wild() {
    }

    @Override
    protected String makeVoice() {
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
