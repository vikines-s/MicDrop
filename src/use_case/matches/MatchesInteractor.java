package use_case.matches;

import java.util.HashMap;

public class MatchesInteractor implements MatchesInputBoundary {
    final MatchesDataAccessInterface userDataAccessObject;

    final HashMap accounts;
    final MatchesOutputBoundary matchPresenter;
    final MatchingAlgorithm algo;
    public MatchesInteractor(MatchesDataAccessInterface userDataAccessObject,
                             MatchesOutputBoundary matchPresenter, MatchingAlgorithm algo){
        this.userDataAccessObject = userDataAccessObject;
        this.accounts = userDataAccessObject.getAccounts();
        this.matchPresenter = matchPresenter;
        this.algo = algo;

    public void execute(MatchesInputData matchesInputData) {
        int numMatches = 0;
        }
        if (!userDataAccessObject.usersExist()) {
            matchPresenter.prepareFailView("There is nobody to match with!");
        }
        else {
            //TODO implement this
        }
        }
}
