package entity;

import java.net.URI;
import java.util.ArrayList;

public class CommonUser implements User {

    private final String username;
    // private URI uri = null;
    // private URI FutureURI = null;
    // private int expiryTime = 0;
    private String birthdate = null;
    private ArrayList<String> topTracks = new ArrayList<String>();
    private ArrayList<String> topArtists = new ArrayList<String>();
    private ArrayList<String> topGenres = new ArrayList<String>();

    CommonUser(String username) {
        this.username = username;
    }
    @Override
    public String getName() {
        return username;
    }

    @Override
    public ArrayList<String> getFavouriteArtists() {
        return this.topArtists;
    }

    @Override
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public void setTopTracks(ArrayList<String> tracks) {
        this.topTracks = tracks;
    }

    @Override
    public void setTopArtists(ArrayList<String> artists) {
        this.topArtists = artists;
    }

    @Override
    public void setTopGenres(ArrayList<String> userGenres) {
        this.topGenres = userGenres;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    @Override
    public ArrayList<String> getTopTracks() {
        return this.topTracks;
    }

    @Override
    public ArrayList<String> getTopGenres() {
        return this.topGenres;
    }

}
