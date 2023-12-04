package use_case.login;

import entity.User;

public interface LogInSpotifyAccessInterface {
    void updateUserData(User user, String authCode);
}
