package entity;

import java.net.URI;
import java.util.ArrayList;

public interface User {

    String getName();
    void setURI(URI uri);
    void setFutureURI(URI uri);
    URI getURI();
    void setRefreshTokenExpiry(int expiryTime);
    int getRefreshTokenExpiry();

    String getPassword();

    ArrayList<String> getFavouriteArtists();

}
