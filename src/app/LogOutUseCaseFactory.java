package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.logout.LogOutViewModel;
import interface_adapter.signup.SignUpViewModel;
import use_case.logout.LogOutDataAccessInterface;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;

public class LogOutUseCaseFactory {
    private LogOutUseCaseFactory() {}
    public static LogOutController create(LogOutViewModel logOutViewModel,
                                          LogOutDataAccessInterface spotifyDataAccessObject,
                                          SignUpViewModel signUpViewModel, ViewManagerModel viewManagerModel) {
        LogOutOutputBoundary logOutPresenter = new LogOutPresenter(logOutViewModel, signUpViewModel, viewManagerModel);
        LogOutInputBoundary logOutInteractor = new LogOutInteractor(logOutPresenter, spotifyDataAccessObject);
        return new LogOutController(logOutInteractor);
    }
}
