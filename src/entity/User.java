package entity;

import java.net.URI;
import java.util.ArrayList;

public interface User {

    String getName();

    ArrayList<String> getFavouriteArtists();

    void setBirthdate(String birthdate);
    void setTopTracks(ArrayList<String> tracks);
    void setTopArtists(ArrayList<String> artists);

    void setTopGenres(ArrayList<String> userGenres);

    String getBirthdate();
    ArrayList<String> getTopTracks();
    ArrayList<String> getTopGenres();
}
