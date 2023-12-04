package use_case.matches;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MatchesOutputData {
    public HashMap matches;
    public String currentUser;
    public String matchType;
    public MatchesOutputData(LinkedHashMap matches, String currentUser, String matchType) {
        this.matches = matches;
        this.currentUser = currentUser;
        this.matchType = matchType;
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