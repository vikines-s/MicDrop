package interface_adapter.matches;

import interface_adapter.ViewManagerModel;
import use_case.matches.MatchesOutputBoundary;
import use_case.matches.MatchesOutputData;
import view.ViewManager;

public class MatchesPresenter implements MatchesOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final MatchesViewModel matchesViewModel;
    public MatchesPresenter(MatchesViewModel matchesViewModel, ViewManagerModel viewManagerModel){
        this.matchesViewModel = matchesViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    public void prepareFailView(String error) {
        MatchesState state = matchesViewModel.getState();
        state.setError(error);
        this.matchesViewModel.setState(state);
        this.matchesViewModel.firePropertyChanged();

    }
    public void prepareSuccessView(MatchesOutputData data) {
        MatchesState state = matchesViewModel.getState();
        state.setMatchType(data.getMatchType());
        state.setMatches(data.getMatch1(), data.getMatch2(), data.getMatch3(), data.getMatch4(), data.getMatch5());
        this.matchesViewModel.setState(state);
        matchesViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(matchesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
