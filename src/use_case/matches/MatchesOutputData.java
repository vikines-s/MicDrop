package use_case.matches;

import java.util.*;

public class MatchesOutputData {
    public String match1;
    public String match2;
    public String match3;
    public String match4;
    public String match5;
    public String matchType;
    public MatchesOutputData(LinkedHashMap matches, String matchType) {
        this.matchType = matchType;
        ArrayList<Object> allMatches = new ArrayList<>(10);
        for (Map.Entry<Object, Object> entry : matches.entrySet()) {
            allMatches.add(entry.getKey());
            allMatches.add(entry.getValue());
        }
        int addNull = 10 - allMatches.size();
        for (int i=0; i<addNull; i++) {
            allMatches.add(null);
        }
        match1 =



    }
    public String getMatches() {
        //TODO implement this
        return null;
    }
    public String getMatchedUser() {
        return currentUser;
    }
    public String getMatchType() {
        return matchType;
    }
}