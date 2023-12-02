package use_case.match;

import entity.User;

import java.util.HashMap;

public interface MatchDataAccessInterface {
    HashMap getAccounts();

    User get(String username);

    boolean usersExist();
}
