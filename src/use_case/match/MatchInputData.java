package use_case.match;

public class MatchInputData {
    final private String username;
    public MatchInputData(String username){
        this.username = username;
    }
    String getUsername(){ return this.username; }
}
