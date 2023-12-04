package use_case.logout;

public class LogOutInteractor implements LogOutInputBoundary{
    final LogOutOutputBoundary userPresenter;

    final LogOutDataAccessInterface spotifyDataAccessObject;

    public LogOutInteractor (LogOutOutputBoundary logOutOutputBoundary, LogOutDataAccessInterface spotifyDataAccessObject) {
        this.userPresenter = logOutOutputBoundary;
        this.spotifyDataAccessObject = spotifyDataAccessObject;
    }

    public void execute(LogOutInputData logOutInputData) {
        spotifyDataAccessObject.clearAuthorization();
        LogOutOutputData logOutOutputData = new LogOutOutputData(logOutInputData.getUsername());
        userPresenter.prepareLogoutView(logOutOutputData);
    }
}
