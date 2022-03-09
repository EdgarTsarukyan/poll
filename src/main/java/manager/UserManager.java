package manager;

import model.User;

import java.util.List;

public interface UserManager {

    List<User> getAllUsers();

    User getByEmailAndPassword(String email, String password);

    User getUserById(int id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

}
