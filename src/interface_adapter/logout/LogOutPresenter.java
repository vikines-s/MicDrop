package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignUpViewModel;
import use_case.logout.LogOutOutputBoundary;
import use_case.logout.LogOutOutputData;

public class LogOutPresenter implements LogOutOutputBoundary {
    private final LogOutViewModel logOutViewModel;

    private final SignUpViewModel signUpViewModel;

    private final ViewManagerModel viewManagerModel;

    public LogOutPresenter(LogOutViewModel logOutViewModel, SignUpViewModel signUpViewModel, ViewManagerModel viewManagerModel) {
        this.logOutViewModel = logOutViewModel;
        this.signUpViewModel = signUpViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareLogoutView(LogOutOutputData logOutOutputData) {
        LogOutState state = logOutViewModel.getState();
        state.setUsername(logOutOutputData.getUsername());
        viewManagerModel.setActiveView(signUpViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        logOutViewModel.setState(state);
        logOutViewModel.firePropertyChanged();
    }
}
