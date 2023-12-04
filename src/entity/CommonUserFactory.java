package entity;

import java.util.ArrayList;

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String username) {
        return new CommonUser(username);
    }

    @Override
    public User create(String username, String birthdate, ArrayList<String> topTracks, ArrayList<String> topArtists, ArrayList<String> topGenres) {
        User user = new CommonUser(username);
        user.setBirthdate(birthdate);
        user.setTopTracks(topTracks);
        user.setTopArtists(topArtists);
        user.setTopGenres(topGenres);
        return user;
    }
}
