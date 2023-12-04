package use_case.matches;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

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
