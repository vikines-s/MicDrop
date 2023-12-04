package interface_adapter.matches;

import interface_adapter.ViewManagerModel;
import use_case.matches.MatchesOutputData;
import view.ViewManager;

public class MatchesPresenter {
    private final ViewManagerModel viewManagerModel;
    private final MatchesViewModel matchesViewModel;
    public MatchesPresenter(MatchesViewModel matchesViewModel, ViewManagerModel viewManagerModel){
        this.matchesViewModel = matchesViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    public void PrepareFailView(String error) {
        MatchesState state = matchesViewModel.getState();
        state.setError(error);
        this.matchesViewModel.setState(state);
        this.matchesViewModel.firePropertyChanged();

    }
    public void PrepareSuccessView(MatchesOutputData data) {
        MatchesState state = matchesViewModel.getState();
        state.setMatchType(data.getMatchType());
//TODO: set matches to stat once format of output data is decided
        this.matchesViewModel.setState(state);
        this.matchesViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(matchesViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}