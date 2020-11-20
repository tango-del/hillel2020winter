package lesson5;

public class GuideDog extends Dog {
    public GuideDog(String name, boolean trained) {
        this.setName(name);
        this.trained = trained;
    }


    private boolean trained;

    @Override
    protected String makeVoice() {
        if (trained) {
            return "Hello, my name is " + getName() + " Woof. I can take you home.";
        } else
            return super.makeVoice();
    }

    private void bringHome() {

    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }
}
