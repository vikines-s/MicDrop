package entity;

import java.util.ArrayList;

public class CommonUser implements User{

    private final String username;
    private final String password;

    CommonUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public String getName() {
        return username;
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
