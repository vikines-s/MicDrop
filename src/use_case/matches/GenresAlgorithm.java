package use_case.matches;

import entity.User;

import java.util.ArrayList;

public class GenresAlgorithm implements MatchingAlgorithm{
    @Override
    public Integer getMatchScore(User user1, User user2) {
        int count = 0;
        ArrayList<String> list1 = user1.getTopGenres();
        ArrayList<String> list2 = user2.getTopGenres();
        for (String genre: list1) {
            if (list2.contains(genre)) {
                count += 1;
            }
        }
        return count;
    }

    @Override
    public String getMatchType() {
        return "genres";
    }
}