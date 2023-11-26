package entity;

import java.net.URI;
import java.util.ArrayList;

public class CommonUser implements User{

    private final String username;
    // private URI uri = null;
    // private URI FutureURI = null;
    // private int expiryTime = 0;
    private String birthdate = null;

    CommonUser(String username) {
        this.username = username;
    }
    @Override
    public String getName() {
        return username;
    }


    /**
    @Override
    public void setURI(URI uri) {
        this.uri = uri;
    }

    @Override
    public void setFutureURI(URI uri) {
        this.FutureURI = uri;
    }

    @Override
    public URI getURI() {
        return this.uri;
    }

    @Override
    public void setRefreshTokenExpiry(int expiryTime) {
        this.expiryTime = expiryTime;
    }

    @Override
    public int getRefreshTokenExpiry() {
        return this.expiryTime;
    }
 **/

    @Override
    public ArrayList<String> getFavouriteArtists() {
        return null;
    }

    @Override
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public void setTopTracks(ArrayList<String> tracks) {

    }

    @Override
    public void setTopArtists(ArrayList<String> artists) {

    }

    @Override
    public void setTopGenres(ArrayList<String> userGenres) {

    }

}
