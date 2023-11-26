package entity;

import java.net.URI;
import java.util.ArrayList;

public interface User {

    String getName();
    // void setURI(URI uri);
    // void setFutureURI(URI uri);
    // URI getURI();
    // void setRefreshTokenExpiry(int expiryTime);
    // int getRefreshTokenExpiry();

    ArrayList<String> getFavouriteArtists();

    void setBirthdate(String birthdate);
    void setTopTracks(ArrayList<String> tracks);
    void setTopArtists(ArrayList<String> artists);

    void setTopGenres(ArrayList<String> userGenres);

    String getBirthdate();
    ArrayList<String> getTopTracks();
    ArrayList<String> getTopGenres();
}
