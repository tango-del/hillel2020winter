package lesson5;

public class Predator extends Wild{
    public Predator() {
    }

    @Override
    protected String makeVoice() {
        return "I am a wild animal and I am angry";
    }
}
