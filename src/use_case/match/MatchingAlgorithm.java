package use_case.match;

import entity.User;

public interface MatchingAlgorithm {
    InduvidualMatchData getSimilarity(User user1, User user2) {

    }
}
