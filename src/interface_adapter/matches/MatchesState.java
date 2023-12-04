package interface_adapter.matches;

public class MatchesState {
    private String error = null;
    private String matchType = "";
    private String matches = "";
    public MatchesState(MatchesState copy) {
        this.matches = matches;
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
    public void setMatches(String matches) {
        this.matches = matches;
    }
    public String getMatches() {
        return this.matches;
    }}

