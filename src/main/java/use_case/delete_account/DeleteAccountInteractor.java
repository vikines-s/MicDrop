package use_case.delete_account;

public class DeleteAccountInteractor implements DeleteAccountInputBoundary {
    final DeleteAccountDataAccessInterface userDataAccessObject;
    final DeleteAccountOutputBoundary deleteAccountPresenter;
    public DeleteAccountInteractor(DeleteAccountDataAccessInterface userDataAccessObject,
                                   DeleteAccountOutputBoundary deleteAccountPresenter){
        this.userDataAccessObject = userDataAccessObject;
        this.deleteAccountPresenter = deleteAccountPresenter;
    }
    public void execute(DeleteAccountInputData deleteAccountInputData){
        String username = deleteAccountInputData.getUsername();
        userDataAccessObject.deleteAccount(username);
        DeleteAccountOutputData deletedUser = new DeleteAccountOutputData(username);
        deleteAccountPresenter.prepareDeletedAccountView(deletedUser);
    }
}
