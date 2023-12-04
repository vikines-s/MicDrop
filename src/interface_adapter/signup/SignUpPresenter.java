package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.signup.SignUpOutputBoundary;
import use_case.signup.SignUpOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SignUpPresenter implements SignUpOutputBoundary {
    private final SignUpViewModel signupViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public SignUpPresenter(SignUpViewModel signupViewModel, ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel) {
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView(SignUpOutputData user) {
        SignUpState signupState = signupViewModel.getState();
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(user.getUser().getName());
        loggedInState.setTopArtists(user.getUser().getFavouriteArtists().toString());
        loggedInState.setTopGenres(user.getUser().getTopGenres().toString());
        loggedInState.setTopTracks(user.getUser().getTopTracks().toString());
        this.loggedInViewModel.setState(loggedInState);
        loggedInViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SignUpState signUpState = signupViewModel.getState();
        signUpState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }
}
