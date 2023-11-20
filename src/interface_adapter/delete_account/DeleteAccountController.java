package interface_adapter.delete_account;

import use_case.delete_account.*;

public class DeleteAccountController {
    final DeleteAccountInputBoundary deleteAccountUseCaseInteractor;
    public DeleteAccountController(DeleteAccountInputBoundary deleteAccountUseCaseInteractor) {
        this.deleteAccountUseCaseInteractor = deleteAccountUseCaseInteractor;
    }
    // TODO: add the input for execute (should be either a username or a user object of the current profile
    public void execute(String username){
        DeleteAccountInputData deleteAccountInputData = new DeleteAccountInputData(username);
        deleteAccountUseCaseInteractor.execute(deleteAccountInputData);
    }
}
