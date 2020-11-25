package lesson6.IntAnimal;

public interface InterfaceAnimal {
    default String makeVoice(){
        return "Hello, i am Animal";
    }
    default String move() {
        return "Animal move on four legs";
    }
}
