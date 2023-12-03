package use_case.matches;

import entity.User;

import java.util.HashMap;

public interface MatchesDataAccessInterface {
    HashMap getAccounts();

    User get(String username);

    boolean usersExist();
}
