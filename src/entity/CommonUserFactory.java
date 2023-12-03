package entity;

import java.util.ArrayList;

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String username) {
        return null;
    }

    @Override
    public User create(String username, String birthdate, ArrayList<String> topTracks, ArrayList<String> topArtists, ArrayList<String> topGenres) {
        return null;
    }
}
