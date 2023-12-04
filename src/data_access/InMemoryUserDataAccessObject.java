package data_access;

import entity.User;
import use_case.delete_account.DeleteAccountDataAccessInterface;
import use_case.login.LogInSpotifyAccessInterface;
import use_case.login.LogInUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements DeleteAccountDataAccessInterface,
        LogInUserDataAccessInterface, LogInSpotifyAccessInterface {
    public Map<String, User> accounts = new HashMap<>();
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }
    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
    }
    public User get(String username) {
        return accounts.get(username);
    }
    public void deleteAccount(String username) {
        accounts.remove(username);
    }

    @Override
    public void updateUserData(User user) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hi");
        user.setTopGenres(list);
        user.setTopTracks(list);
        user.setTopArtists(list);
    }
}
