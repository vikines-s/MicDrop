package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface UserFactory {
    User create(String username);
    User create(String username, String birthdate, ArrayList<String> topTracks, ArrayList<String> topArtists,
                ArrayList<String> topGenres);
}

