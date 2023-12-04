package use_case.matches;

import entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public class ArtistsAlgorithm implements MatchingAlgorithm{
    @Override
    public int getMatchScore(User user1, User user2) {
        int count = 0;
        ArrayList<String> list1 = user1.getFavouriteArtists();
        ArrayList<String> list2 = user2.getFavouriteArtists();
        for (String artist: list1) {
            if (list2.contains(artist)) {
                count += 1;
            }
        }
        return count;
    }
}
