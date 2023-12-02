package use_case.match;

public interface MatchOutputBoundary {

    void prepareSuccessView(MatchOutputData matchOutputData);

    void prepareFailView(String error);
}
