package use_case.signup;

import entity.User;

public interface SignUpUserDataAccessInterface {
    void save(User user);

    boolean existsByName(String identifier);
}
