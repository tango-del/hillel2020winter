package lesson6;

public class Main {
    public static void main(String[] args) {
        createAnimal();
        System.out.println("-------");

        createHomeAnimal();
        System.out.println("-------");

        createWild();
        System.out.println("-------");

        createCat();
        System.out.println("-------");

        createFish();
        System.out.println("-------");

        createDog();
        System.out.println("-------");

        createGiraffe();
        System.out.println("-------");

        createPredator();
        System.out.println("-------");
    }
    public static void createAnimal() {
        Animal animal = new Animal();
        System.out.println(animal.makeVoice());
        System.out.println(animal.move());
    }
    public static void createHomeAnimal() {
        HomeAnimal homeAnimal = new HomeAnimal();
        homeAnimal.setName("Bob");
        System.out.println(homeAnimal.makeVoice());
        System.out.println(homeAnimal.move());
    }
    public static void createWild() {
        Wild wild = new Wild();
        System.out.println(wild.makeVoice());
    }
    public static void createCat() {
        Cat cat = new Cat();
        cat.setName("Kitty");
        System.out.println(cat.makeVoice());
    }
    public static void createFish() {
        Fish fish = new Fish();
        System.out.println(fish.makeVoice());
        System.out.println(fish.move());
    }
    public static void createDog() {
        Dog dog = new Dog("Nilya", true);
        System.out.println(dog.makeVoice());
        createGuideDog();
    }
    public static void createGuideDog() {
        GuideDog dog1 = new GuideDog("Bobik", true);
        dog1.setVaccinated(true);
        System.out.println(dog1.makeVoice());
    }
    public static void createGiraffe() {
        Giraffe giraffe = new Giraffe();
        System.out.println(giraffe.makeVoice());
    }
    public static void createPredator() {
        Predator predator = new Predator();
        System.out.println(predator.makeVoice());
    }

}
