package interface_adapter.matches;

public class MatchesState {
    private String error = null;
    private String matchType = "";
    public String match1 = "";
    public String match2 = "";
    public String match3 = "";
    public String match4 = "";
    public String match5 = "";
    public MatchesState(MatchesState copy) {
        this.match1 = match1;
        this.match2 = match2;
        this.match3 = match3;
        this.match4 = match4;
        this.match5 = match5;
        this.matchType = matchType;
        this.error = copy.error;
    }
    public MatchesState(){}
    public void setError(String error) {
        this.error = error;
    }
    public String getError() {
        return this.error;
    }
    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }
    public String getMatchType() {
        return this.matchType;
    }
    public void setMatches(String match1, String match2, String match3, String match4, String match5) {
        this.match1 = match1;
        this.match2 = match2;
        this.match3 = match3;
        this.match4 = match4;
        this.match5 = match5;
    }
    public String getMatches() {
        return (this.match1 + "\n" + this.match2 + "\n" + this.match3 + "\n" + this.match4 + "\n" + this.match5);
    }
}

