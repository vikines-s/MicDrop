package interface_adapter.logged_in;

public class LoggedInState {
    private String username = "";
    private String topTracks = "";
    private String topArtists = "";
    private String topGenres = "";
    public LoggedInState(LoggedInState copy) {
        this.username = copy.username;
        this.topTracks =copy.topTracks;
        this.topArtists = copy.topArtists;
        this.topGenres = copy.topGenres;
    }
    public LoggedInState() {}
    public String getUsername() { return this.username; }
    public void setUsername(String username) { this.username = username; }
    public void setTopTracks(String topTracks) { this.topTracks = topTracks; }
    public String getTopTracks() { return this.topTracks; }
    public void setTopArtists(String topArtists) { this.topArtists = topArtists; }
    public String getTopArtists() { return this.topArtists; }
    public void setTopGenres(String topGenres) { this.topGenres = topGenres; }
    public String getTopGenres() { return this.topGenres; }
}
