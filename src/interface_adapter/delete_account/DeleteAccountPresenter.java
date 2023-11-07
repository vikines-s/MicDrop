package interface_adapter.delete_account;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup_login.SignUpLogInViewModel;
import use_case.delete_account.DeleteAccountOutputBoundary;
//TODO make sure the view models being used are correct (should i create a DeletedAccountViewModel since
// there is no information to present)
public class DeleteAccountPresenter implements DeleteAccountOutputBoundary {
    private final SignUpLogInViewModel signUpLogInViewModel;
    private ViewManagerModel viewManagerModel;
    public DeleteAccountPresenter(SignUpLogInViewModel signUpLogInViewModel,
                                  ViewManagerModel viewManagerModel){
        this.signUpLogInViewModel = signUpLogInViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareDeletedAccountView(){
        this.viewManagerModel.setActiveView(signUpLogInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
