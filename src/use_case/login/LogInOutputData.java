package use_case.login;

import java.util.ArrayList;

public class LogInOutputData {
    private final String username;
    private final ArrayList<String> topTracks;
    private final ArrayList<String> topArtists;
    private final ArrayList<String> topGenres;

    public LogInOutputData(String username, ArrayList<String> topTracks,
                           ArrayList<String> topArtists, ArrayList<String> topGenres) {
        this.username = username;
        this.topTracks = topTracks;
        this.topArtists = topArtists;
        this.topGenres = topGenres;
    }
    public String getUsername() { return this.username; }
}
