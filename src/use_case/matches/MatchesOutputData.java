package use_case.matches;

import java.util.*;

public class MatchesOutputData {
    public String match1 = "";
    public String match2 = "";
    public String match3 = "";
    public String match4 = "";
    public String match5 = "";
    public String matchType;

    public MatchesOutputData(LinkedHashMap<String, Integer> matches, String matchType) {
        this.matchType = matchType;
        ArrayList<Object> allMatches = new ArrayList<>(10);
        for (Map.Entry<String, Integer> entry : matches.entrySet()) {
            allMatches.add(entry.getKey());
            allMatches.add(entry.getValue());
        }
        int addNull = 10 - allMatches.size();
        for (int i=0; i<addNull; i++) {
            allMatches.add(null);
        }
        if (allMatches.get(1) != null) {
            match1 = "Match 1:\n# of matching " + matchType + ": " + allMatches.get(1).toString() + "\nUser's email: " + allMatches.get(0);
        } if (allMatches.get(3) != null) {
            match2 = "Match 2:\n# of matching " + matchType + ": " + allMatches.get(3).toString() + "\nUser's email: " + allMatches.get(2);
        } if (allMatches.get(5) != null) {
            match3 = "Match 3:\n# of matching " + matchType + ": " + allMatches.get(5).toString() + "\nUser's email: " + allMatches.get(4);
        } if (allMatches.get(7) != null) {
            match4 = "Match 4:\n# of matching " + matchType + ": " + allMatches.get(7).toString() + "\nUser's email: " + allMatches.get(6);
        } if (allMatches.get(9) != null) {
            match5 = "Match 5:\n# of matching " + matchType + ": " + allMatches.get(9).toString() + "\nUser's email: " + allMatches.get(8);
        }
    }
    public String getMatch1() { return match1;}
    public String getMatch2() { return match2;}
    public String getMatch3() { return match3;}
    public String getMatch4() { return match4;}
    public String getMatch5() { return match5;}

    public String getMatchType() {
        return matchType;
    }
}