package use_case.matches;

import entity.User;

import java.util.*;

public class MatchesInteractor implements MatchesInputBoundary {
    final MatchesDataAccessInterface userDataAccessObject;

    final HashMap accounts;
    final MatchesOutputBoundary matchPresenter;
    public MatchesInteractor(MatchesDataAccessInterface userDataAccessObject,
                             MatchesOutputBoundary matchPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.accounts = userDataAccessObject.getAccounts();
        this.matchPresenter = matchPresenter;
    }

    public void execute(MatchesInputData matchesInputData) {
        LinkedHashMap sortedMatches = new LinkedHashMap();
        HashMap matches = new HashMap<>();
        String currentUser = matchesInputData.getUsername();
        MatchingAlgorithm algo = matchesInputData.getAlgorithm();
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
                    matches.put(pair.getValue(), algo.getMatchScore(userDataAccessObject.get(currentUser), (User) pair.getValue()));
                    it.remove();
                }
                for (int i = 0; i < 5; i++) {
                    if (matches.isEmpty()) {
                        break;
                    }
                    User max = (User) Collections.max(matches.entrySet(), Map.Entry.comparingByValue()).getKey();
                    sortedMatches.put(max.getEmail(), matches.get(max));
                    matches.remove(max);
                    //TODO remove the key value pair after you find the max, find the max again etc.
                    //TODO break if matches empty or wtv
                }
                MatchesOutputData matchesOutputData = new MatchesOutputData(sortedMatches, algo.getMatchType());
            }
        }
    }
}
