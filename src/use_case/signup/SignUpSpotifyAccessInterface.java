package use_case.signup;

import entity.User;

public interface SignUpSpotifyAccessInterface {
    User signUpUser(String authCode);
}
