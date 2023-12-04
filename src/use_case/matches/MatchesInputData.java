package use_case.matches;

public class MatchesInputData {
    final private String username;

    final private MatchingAlgorithm chosenAlgorithm;
    public MatchesInputData(String username, MatchingAlgorithm chosenAlgorithm){
        this.username = username;
        this.chosenAlgorithm = chosenAlgorithm;
    }
    String getUsername(){ return this.username; }

    MatchingAlgorithm getAlgorithm() { return this.chosenAlgorithm; }
}
