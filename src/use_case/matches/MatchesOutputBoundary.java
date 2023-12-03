package use_case.matches;

public interface MatchesOutputBoundary {

    void prepareSuccessView(MatchesOutputData matchesOutputData);

    void prepareFailView(String error);
}
