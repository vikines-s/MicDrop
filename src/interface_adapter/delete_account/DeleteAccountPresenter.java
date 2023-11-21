package interface_adapter.delete_account;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup_login.SignUpLogInViewModel;
import use_case.delete_account.DeleteAccountOutputBoundary;
import use_case.delete_account.DeleteAccountOutputData;

//TODO make sure the view models being used are correct (should i create a DeletedAccountViewModel since
// there is no information to present)
public class DeleteAccountPresenter implements DeleteAccountOutputBoundary {
    private final SignUpLogInViewModel signUpLogInViewModel;
    private final DeleteAccountViewModel deleteAccountViewModel;
    private ViewManagerModel viewManagerModel;
    public DeleteAccountPresenter(SignUpLogInViewModel signUpLogInViewModel,
                                  DeleteAccountViewModel deleteAccountViewModel,
                                  ViewManagerModel viewManagerModel){
        this.signUpLogInViewModel = signUpLogInViewModel;
        this.deleteAccountViewModel = deleteAccountViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareDeletedAccountView(DeleteAccountOutputData deletedUser){
        String username = deletedUser.getDeletedUser();
        DeleteAccountState state = deleteAccountViewModel.getState();
        state.setUser(username);
        deleteAccountViewModel.setState(state);
        deleteAccountViewModel.firePropertyChanged();
    }
}
