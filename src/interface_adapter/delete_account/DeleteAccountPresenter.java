package interface_adapter.delete_account;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup_login.SignupLoginViewModel;
import use_case.delete_account.DeleteAccountOutputBoundary;
import use_case.delete_account.DeleteAccountOutputData;

//TODO make sure the view models being used are correct (should i create a DeletedAccountViewModel since
// there is no information to present)
public class DeleteAccountPresenter implements DeleteAccountOutputBoundary {
    private final SignupLoginViewModel signupLoginViewModel;
    private final DeleteAccountViewModel deleteAccountViewModel;
    private ViewManagerModel viewManagerModel;
    public DeleteAccountPresenter(SignupLoginViewModel signupLoginViewModel,
                                  DeleteAccountViewModel deleteAccountViewModel,
                                  ViewManagerModel viewManagerModel){
        this.signupLoginViewModel = signupLoginViewModel;
        this.deleteAccountViewModel = deleteAccountViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareDeletedAccountView(DeleteAccountOutputData deletedUser){
        String username = deletedUser.getDeletedUser();
        DeleteAccountState state = deleteAccountViewModel.getState();
        state.setUser(username);
        viewManagerModel.setActiveView(signupLoginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        deleteAccountViewModel.setState(state);
        deleteAccountViewModel.firePropertyChanged();
    }
}
