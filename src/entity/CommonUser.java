package entity;

import java.net.URI;
import java.util.ArrayList;

public class CommonUser implements User{

    private final String username;
    private final String password;
    private URI uri = null;
    private URI FutureURI = null;
    private int expiryTime = 0;

    CommonUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public String getName() {
        return username;
    }

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

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public ArrayList<String> getFavouriteArtists() {
        return null;
    }

}
