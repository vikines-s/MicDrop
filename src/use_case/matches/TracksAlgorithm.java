package use_case.matches;

import entity.User;

import java.util.ArrayList;

public class TracksAlgorithm implements MatchingAlgorithm{
    @Override
    public Integer getMatchScore(User user1, User user2) {
        int count = 0;
        ArrayList<String> list1 = user1.getTopTracks();
        ArrayList<String> list2 = user2.getTopTracks();
        for (String track: list1) {
            if (list2.contains(track)) {
                count += 1;
            }
        }
        return count;
    }

    @Override
    public String getMatchType() {
        return "tracks";
    }
}