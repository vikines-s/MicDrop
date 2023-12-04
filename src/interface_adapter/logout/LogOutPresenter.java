package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LogInViewModel;
import interface_adapter.signup.SignUpViewModel;
import use_case.logout.LogOutOutputBoundary;
import use_case.logout.LogOutOutputData;

public class LogOutPresenter implements LogOutOutputBoundary {
    private final LogOutViewModel logOutViewModel;

    private final LogInViewModel loginViewModel;

    private final ViewManagerModel viewManagerModel;

    public LogOutPresenter(LogOutViewModel logOutViewModel, LogInViewModel loginViewModel, ViewManagerModel viewManagerModel) {
        this.logOutViewModel = logOutViewModel;
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareLogoutView(LogOutOutputData logOutOutputData) {
        LogOutState state = logOutViewModel.getState();
        state.setUsername(logOutOutputData.getUsername());
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        logOutViewModel.setState(state);
        logOutViewModel.firePropertyChanged();
    }
}
