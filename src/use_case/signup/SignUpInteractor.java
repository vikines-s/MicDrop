package use_case.signup;

import entity.User;

public class SignUpInteractor implements SignUpInputBoundary {

    final SignUpSpotifyAccessInterface spotifyDataAccessObject; // signUpUser
    final SignUpUserDataAccessInterface userDataAccessObject; // save, exists by name
    final SignUpOutputBoundary userPresenter;

    public SignUpInteractor(SignUpSpotifyAccessInterface spotifyDataAccessObject, SignUpUserDataAccessInterface userDataAccessObject, SignUpOutputBoundary userPresenter) {
        this.spotifyDataAccessObject = spotifyDataAccessObject;
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
    }

    @Override
    public void execute(SignUpInputData signUpInputData) {
        if (userDataAccessObject.existsByName(signUpInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else {
            User user = spotifyDataAccessObject.signUpUser(signUpInputData.getAuthorizationCode());
            userDataAccessObject.save(user);

            SignUpOutputData signUpOutputData = new SignUpOutputData(user.getName(), user.getTopTracks(),
                    user.getFavouriteArtists(), user.getTopGenres(), false);
            userPresenter.prepareSuccessView(signUpOutputData);

        }
    }
}
