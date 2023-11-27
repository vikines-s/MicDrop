package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import use_case.signup.SignUpOutputBoundary;
import use_case.signup.SignUpOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SignUpPresenter implements SignUpOutputBoundary {
    private final SignUpViewModel signupViewModel;
    //TODO: private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public SignUpPresenter(SignUpViewModel signupViewModel, ViewManagerModel viewManagerModel) {
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(SignUpOutputData user) {
        SignUpState signupState = signupViewModel.getState();
        //LoginState loginState = loginViewModel.getState();
        //loginState.setUsername(response.getUsername());
        //this.loginViewModel.setState(loginState);
        //loginViewModel.firePropertyChanged();
        //TODO: viewManagerModel.setActiveView(loggedinViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SignUpState signUpState = signupViewModel.getState();
        signUpState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }
}
