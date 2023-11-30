package interface_adapter.delete_account;

import use_case.delete_account.*;

public class DeleteAccountController {
    final DeleteAccountInputBoundary deleteAccountUseCaseInteractor;
    public DeleteAccountController(DeleteAccountInputBoundary deleteAccountUseCaseInteractor) {
        this.deleteAccountUseCaseInteractor = deleteAccountUseCaseInteractor;
    }
    public void execute(String username){
        DeleteAccountInputData deleteAccountInputData = new DeleteAccountInputData(username);
        deleteAccountUseCaseInteractor.execute(deleteAccountInputData);
    }
}
