package use_case.matches;

public class MatchesInputData {
    final private String username;

    final private String chosenAlgorithm;
    public MatchesInputData(String username, String chosenAlgorithm){
        this.username = username;
        this.chosenAlgorithm = chosenAlgorithm;
    }
    String getUsername(){
        return this.username;
    }

    String getAlgorithm() {
        return this.chosenAlgorithm;
    }
}
