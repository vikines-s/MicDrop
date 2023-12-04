package app;

import data_access.FileUserSpotifyAccessObject;
import data_access.SpotifyDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.delete_account.DeleteAccountViewModel;

import interface_adapter.get_auth_code.GetAuthCodeController;
import interface_adapter.get_auth_code.GetAuthCodeViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LogInController;
import interface_adapter.login.LogInViewModel;

import interface_adapter.logout.LogOutViewModel;
import interface_adapter.signup.SignUpController;
import interface_adapter.signup.SignUpPresenter;
import interface_adapter.signup.SignUpViewModel;
import use_case.signup.SignUpInputBoundary;
import use_case.signup.SignUpInteractor;
import use_case.signup.SignUpOutputBoundary;
import view.SignupLoginView;

import javax.swing.*;
import java.io.IOException;

public class SignUpUseCaseFactory {

    private SignUpUseCaseFactory() {}
    public static SignupLoginView create(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel, LogInViewModel loginViewModel, SignUpViewModel signupViewModel, GetAuthCodeViewModel getAuthCodeViewModel, LogInController loginController, GetAuthCodeController getAuthCodeController, FileUserSpotifyAccessObject userDataAccessObject, SpotifyDataAccessObject spotifyDataAccessObject,
                                         DeleteAccountViewModel deleteAccountViewModel, LogOutViewModel logOutViewModel) {

        try {
            SignUpController signupController = createUserSignupUseCase(viewManagerModel, loggedInViewModel, signupViewModel, userDataAccessObject, spotifyDataAccessObject);
            return new SignupLoginView(signupViewModel, loginViewModel, signupController, loginController, getAuthCodeViewModel, getAuthCodeController, deleteAccountViewModel, logOutViewModel); // TODO: IMPLEMENT THE DELETE VIEW MODEL PROPERLY
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignUpController createUserSignupUseCase(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel, SignUpViewModel signupViewModel, FileUserSpotifyAccessObject userDataAccessObject, SpotifyDataAccessObject spotifyDataAccessObject) throws IOException {

        SignUpPresenter signUpPresenter = new SignUpPresenter(signupViewModel, viewManagerModel, loggedInViewModel);

        UserFactory userFactory = new CommonUserFactory();

        SignUpInputBoundary userSignupInteractor = new SignUpInteractor(spotifyDataAccessObject, userDataAccessObject, signUpPresenter);

        return new SignUpController(userSignupInteractor);
    }
}