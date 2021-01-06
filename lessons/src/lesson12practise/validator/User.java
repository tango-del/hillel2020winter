package lesson12practise.validator;

public class User {
    String email;
    Integer age;
    String country;

    public User(String email, Integer age, String country) {
        this.email = email;
        this.age = age;
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
