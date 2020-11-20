package lesson5;

public class Animal {
    public Animal() {
    }

    private short id;
    private short age;
    private short weight;
    private String color;

    protected String makeVoice() {
        return "Hello, i am Animal";
    }

    protected String move() {
        return "Animal move on four legs";
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", age=" + age +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
