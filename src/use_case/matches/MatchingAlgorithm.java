package use_case.matches;

import entity.User;

import java.util.HashMap;

public interface MatchingAlgorithm {
    HashMap getMatchScore(User user1, User user2);

    String getMatchType();
}
