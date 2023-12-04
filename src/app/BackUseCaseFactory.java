package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.back.BackController;
import interface_adapter.back.BackPresenter;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.back.BackInputBoundary;
import use_case.back.BackInteractor;
import use_case.back.BackOutputBoundary;

public class BackUseCaseFactory {
    private BackUseCaseFactory() {}

    public static BackController create(LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel) {
        BackOutputBoundary backPresenter = new BackPresenter(loggedInViewModel, viewManagerModel);
        BackInputBoundary backUseCaseInteractor = new BackInteractor(backPresenter);
        return new BackController(backUseCaseInteractor);
    }
}
