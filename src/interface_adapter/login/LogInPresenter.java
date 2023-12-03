package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.login.LogInOutputBoundary;
import use_case.login.LogInOutputData;

public class LogInPresenter implements LogInOutputBoundary {
    private final LogInViewModel logInViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public LogInPresenter(LogInViewModel logInViewModel, LoggedInViewModel loggedInViewModel,
                          ViewManagerModel viewManagerModel) {
        this.logInViewModel = logInViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(LogInOutputData user) {
        LoggedInState state = loggedInViewModel.getState();
        state.setUsername(user.getUsername());
        state.setTopTracks(user.getTopTracks());
        state.setTopArtists(user.getTopArtists());
        state.setTopGenres(user.getTopGenres());
        this.loggedInViewModel.setState(state);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {
        LogInState state = logInViewModel.getState();
        state.setUsernameError(error);
        logInViewModel.firePropertyChanged();
    }
}
