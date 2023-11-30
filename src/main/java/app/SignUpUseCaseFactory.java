package app;

import data_access.FileUserSpotifyAccessObject;
import data_access.SpotifyDataAccessObject;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.delete_account.DeleteAccountViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignUpController;
import interface_adapter.signup.SignUpPresenter;
import interface_adapter.signup.SignUpViewModel;
import use_case.signup.SignUpInputBoundary;
import use_case.signup.SignUpInteractor;
import use_case.signup.SignUpOutputBoundary;
import view.SignupLoginView;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;

public class SignUpUseCaseFactory {

    private SignUpUseCaseFactory() {}
    public static SignupLoginView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignUpViewModel signupViewModel, LoginController loginController) {

        try {
            SignUpController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel);
            return new SignupLoginView(signupViewModel, signupController, loginController, new DeleteAccountViewModel()); // TODO: IMPLEMENT THE DELETE VIEW MODEL PROPERLY
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignUpController createUserSignupUseCase(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignUpViewModel signupViewModel, FileUserSpotifyAccessObject userDataAccessObject, SpotifyDataAccessObject spotifyDataAccessObject) throws IOException {

        SignUpPresenter signUpPresenter = new SignUpPresenter(signupViewModel, viewManagerModel);
        // Notice how we pass this method's parameters to the Presenter.
        SignUpOutputBoundary signupOutputBoundary = new SignUpPresenter(signupViewModel, viewManagerModel);

        UserFactory userFactory = new CommonUserFactory();

        SignUpInputBoundary userSignupInteractor = new SignUpInteractor(spotifyDataAccessObject, userDataAccessObject, signUpPresenter);

        return new SignUpController(userSignupInteractor);
    }
}
