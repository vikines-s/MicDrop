package use_case.matches;

import entity.User;
import use_case.logout.LogOutOutputData;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MatchesInteractor implements MatchesInputBoundary {
    final MatchesDataAccessInterface userDataAccessObject;

    final HashMap accounts;
    final MatchesOutputBoundary matchPresenter;
    final MatchingAlgorithm algo;
    public MatchesInteractor(MatchesDataAccessInterface userDataAccessObject,
                             MatchesOutputBoundary matchPresenter, MatchingAlgorithm algo) {
        this.userDataAccessObject = userDataAccessObject;
        this.accounts = userDataAccessObject.getAccounts();
        this.matchPresenter = matchPresenter;
        this.algo = algo;
    }

    public void execute(MatchesInputData matchesInputData) {
        int numMatches = 0;
        HashMap matches = new HashMap<>();
        String currentUser = matchInputData.getUsername();
        if (accounts.size() < 2) {
            matchPresenter.prepareFailView("There is nobody to match with!");
        }
        else {
            Iterator it = accounts.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (pair.getKey() == currentUser) {
                    it.remove();
                } else {
                    matches.put(pair.getValue().getEmail(), algo.getMatchScore(userDataAccessObject.get(currentUser), (User) pair.getValue()));
                    it.remove();
                }
                for (int i = 0; i < 5; i++) {
                    String max = (String) Collections.max(matches.entrySet(), Map.Entry.comparingByValue()).getKey();
                    MatchesOutputData matchesOutputData = new MatchesOutputData(sortedMatches,currentUser, algo.getMatchType());
                    //TODO remove the key value pair after you find the max, find the max again etc.
                    //TODO break if matches empty or wtv
                }
            }
        }
    }
}
