package manager;

import model.User;

import java.util.List;

public interface UserResultManager<UserResult, Integer> {

    List<UserResult> findAll();

    List<UserResult> getByEmail(String email);

    void create(UserResult userResult);

}
