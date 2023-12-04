package use_case.signup;

import java.util.ArrayList;

public class SignUpOutputData {

    private final String username;

    //time made?

    private boolean signUpFailed;
    private final ArrayList<String> topTracks;
    private final ArrayList<String> topArtists;
    private final ArrayList<String> topGenres;

    public SignUpOutputData(String username, ArrayList<String> topTracks,
                            ArrayList<String> topArtists, ArrayList<String> topGenres,
                            boolean signUpFailed) {
        this.username = username;
        this.topTracks = topTracks;
        this.topArtists = topArtists;
        this.topGenres = topGenres;
        this.signUpFailed = signUpFailed;
    }
    public String getTopTracks() { return String.join(" ", this.topTracks); }
    public String getTopArtists() { return String.join(" ", this.topArtists); }
    public String getTopGenres() { return String.join(" ", this.topGenres); }
    public String getUsername() {
        return username;
    }

    public boolean isSignUpFailed() {
        return signUpFailed;
    }

}
