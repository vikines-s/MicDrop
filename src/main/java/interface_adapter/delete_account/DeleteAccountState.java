package interface_adapter.delete_account;

public class DeleteAccountState {
    private String user;
    public DeleteAccountState(){
    }
    public void setUser(String username){
        this.user = username;
    }
    public String getUser(){
        return this.user;
    }
}
