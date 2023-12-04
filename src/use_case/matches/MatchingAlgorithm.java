package use_case.matches;

import entity.User;

public interface MatchingAlgorithm {
    Integer getMatchScore(User user1, User user2);

    String getMatchType();
}
