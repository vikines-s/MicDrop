package data_access;

import entity.CommonUserFactory;
import entity.User;
import use_case.delete_account.DeleteAccountDataAccessInterface;
import use_case.get_auth_code.GetAuthCodeDataAccessInterface;
import use_case.login.LogInSpotifyAccessInterface;
import use_case.login.LogInUserDataAccessInterface;
import use_case.logout.LogOutDataAccessInterface;
import use_case.signup.SignUpSpotifyAccessInterface;
import use_case.signup.SignUpUserDataAccessInterface;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements DeleteAccountDataAccessInterface,
        LogInUserDataAccessInterface, LogInSpotifyAccessInterface,
        SignUpUserDataAccessInterface, SignUpSpotifyAccessInterface, LogOutDataAccessInterface {
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
    public void updateUserData(User user, String authcode) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hi");
        user.setBirthdate("May");
        user.setTopGenres(list);
        user.setTopTracks(list);
        user.setTopArtists(list);
    }
    @Override
    public User signUpUser(String authcode) {
        CommonUserFactory userFactory = new CommonUserFactory();
        ArrayList<String> list = new ArrayList<>();
        list.add("hi");
        User user = userFactory.create("Mila", "milabhaloo@mail.utoronto.ca","May", list, list, list);
        return user;
    }

    @Override
    public void clearAuthorization() {

    }
}
