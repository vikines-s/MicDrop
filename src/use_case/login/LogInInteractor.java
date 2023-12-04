package use_case.login;

import entity.User;

public class LogInInteractor implements LogInInputBoundary{
    final LogInUserDataAccessInterface userDataAccessObject;
    final LogInSpotifyAccessInterface spotifyDataAccessObject;
    final LogInOutputBoundary userPresenter;

    public LogInInteractor(LogInUserDataAccessInterface userDataAccessObject,
                           LogInSpotifyAccessInterface spotifyDataAccessObject,
                           LogInOutputBoundary userPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.spotifyDataAccessObject = spotifyDataAccessObject;
        this.userPresenter = userPresenter;
    }

    public void execute(LogInInputData logInInputData) {
        if (!userDataAccessObject.existsByName(logInInputData.getUsername())) {
            userPresenter.prepareFailView("User does not exist");
        } else {
            User user = userDataAccessObject.get(logInInputData.getUsername());
            spotifyDataAccessObject.updateUserData(user, logInInputData.getAuthorization());
            userDataAccessObject.save(user);
            LogInOutputData logInOutputData = new LogInOutputData(user.getName(), user.getTopTracks(),
                    user.getFavouriteArtists(), user.getTopGenres());
            userPresenter.prepareSuccessView(logInOutputData);
        }


    }
}
