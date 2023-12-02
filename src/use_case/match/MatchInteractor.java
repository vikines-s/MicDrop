package use_case.match;

import use_case.delete_account.DeleteAccountDataAccessInterface;
import use_case.delete_account.DeleteAccountOutputBoundary;

import java.util.HashMap;

public class MatchInteractor implements MatchInputBoundary{
    final MatchDataAccessInterface userDataAccessObject;

    final HashMap accounts;
    final MatchOutputBoundary matchPresenter;
    final MatchingAlgorithm algo;
    public MatchInteractor(MatchDataAccessInterface userDataAccessObject,
                                   MatchOutputBoundary matchPresenter, MatchingAlgorithm algo){
        this.userDataAccessObject = userDataAccessObject;
        this.accounts = userDataAccessObject.getAccounts();
        this.matchPresenter = matchPresenter;
        this.algo = algo;

    public void execute(MatchInputData matchInputData) {
        int numMatches = 0;
        }
        if (!userDataAccessObject.usersExist()) {
            matchPresenter.prepareFailView("There is nobody to match with!");
        }
        else {
            for 
        }
        }
}
