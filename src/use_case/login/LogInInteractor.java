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

    //TODO: do i also have to update the file user data access object
    public void execute(LogInInputData logInInputData) {
        if (!userDataAccessObject.existsByName(logInInputData.getUsername())) {
            userPresenter.prepareFailView("User does not exist");
        } else {
            User user = userDataAccessObject.get(logInInputData.getUsername());
            spotifyDataAccessObject.updateUserData(user);
            userDataAccessObject.save(user);
            LogInOutputData logInOutputData = new LogInOutputData(logInInputData.getUsername());
            userPresenter.prepareSuccessView(logInOutputData);
        }


    }
}
