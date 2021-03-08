package spark.tests;

import java.util.Collection;

public interface UserService {
    void addUser(User user);
    Collection<User> getUsers();
    User getUser(String id);
    User editUser(User user) throws UserException;
    void deleteUser(String id);
    boolean userExist(String id);
}
