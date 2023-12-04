package app;

import data_access.SpotifyDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.delete_account.DeleteAccountController;
import interface_adapter.delete_account.DeleteAccountPresenter;
import interface_adapter.delete_account.DeleteAccountViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LogInController;
import interface_adapter.login.LogInPresenter;
import interface_adapter.login.LogInViewModel;
import interface_adapter.signup.SignUpViewModel;
import use_case.delete_account.DeleteAccountDataAccessInterface;
import use_case.delete_account.DeleteAccountInputBoundary;
import use_case.delete_account.DeleteAccountInteractor;
import use_case.delete_account.DeleteAccountOutputBoundary;
import use_case.login.*;

public class LogInUseCaseFactory {
    private LogInUseCaseFactory() {}
    public static LogInController create(LogInViewModel logInViewModel,
                                         LogInUserDataAccessInterface userDataAccessObject,
                                         LogInSpotifyAccessInterface spotifyDataAccessObject,
                                         LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel) {
        LogInOutputBoundary logInOutputBoundary = new LogInPresenter(logInViewModel, loggedInViewModel, viewManagerModel);
        LogInInputBoundary logInInteractor = new LogInInteractor(userDataAccessObject, spotifyDataAccessObject, logInOutputBoundary);
        return new LogInController(logInInteractor);
    }
}
