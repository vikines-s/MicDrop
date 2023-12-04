package use_case.matches;

import entity.User;

public interface MatchingAlgorithm {
    int getMatchScore(User user1, User user2);
}
