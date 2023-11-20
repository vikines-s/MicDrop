package use_case.delete_account;

public class DeleteAccountInputData {
    final private String username;
    public DeleteAccountInputData(String username){
        this.username = username;
    }
    String getUsername(){ return this.username; }
}
