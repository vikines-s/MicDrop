package use_case.login;

import entity.User;

public interface LogInUserDataAccessInterface {
    void save(User user);
    User get(String username);
    boolean existsByName(String username);
}
