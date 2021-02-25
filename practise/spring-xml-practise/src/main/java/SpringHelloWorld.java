import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpringHelloWorld {
    private String helloMessage;
    private User user;
    private Student student;

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    public void getHelloMessage() {
        System.out.println("Hello message: " + helloMessage);
    }

    void init(){
        System.out.println("init : SpringHelloWorld");
    }
}
