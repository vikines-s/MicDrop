package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.delete_account.*;
import use_case.delete_account.*;
import interface_adapter.signup.SignUpViewModel;

public class DeleteAccountUseCaseFactory {
    private DeleteAccountUseCaseFactory() {}
    public static DeleteAccountController create(DeleteAccountViewModel deleteAccountViewModel,
                                                 DeleteAccountDataAccessInterface userDataAccessObject,
                                                 SignUpViewModel signUpViewModel, ViewManagerModel viewManagerModel) {
        DeleteAccountOutputBoundary deleteAccountOutputBoundary = new DeleteAccountPresenter(signUpViewModel, deleteAccountViewModel, viewManagerModel);
        DeleteAccountInputBoundary deleteAccountInteractor = new DeleteAccountInteractor(userDataAccessObject, deleteAccountOutputBoundary);
        return new DeleteAccountController(deleteAccountInteractor);
    }
}
