package interface_adapter.matches;

import use_case.matches.MatchesInputBoundary;
import use_case.matches.MatchesInputData;
import use_case.matches.MatchingAlgorithm;

public class MatchesController {
    final MatchesInputBoundary matchInteractor;

    public MatchesController(MatchesInputBoundary matchInteractor) {
        this.matchInteractor = matchInteractor;

    }
    public void execute(String username, MatchingAlgorithm algorithm) {
        MatchesInputData matchesInputData = new MatchesInputData(username, algorithm);
        matchInteractor.execute(matchesInputData);
    }
}
