package use_case.delete_account;

public class DeleteAccountOutputData {
    private String deletedUser;
    public DeleteAccountOutputData(String username){
        this.deletedUser = username;
    }
    public String getDeletedUser(){
        return this.deletedUser;
    }
}
