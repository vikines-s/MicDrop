package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.matches.MatchesController;
import interface_adapter.matches.MatchesPresenter;
import interface_adapter.matches.MatchesViewModel;
import use_case.matches.MatchesDataAccessInterface;
import use_case.matches.MatchesInputBoundary;
import use_case.matches.MatchesInteractor;
import use_case.matches.MatchesOutputBoundary;

import javax.swing.text.View;

public class MatchesUseCaseFactory {
    private MatchesUseCaseFactory() {}

    public static MatchesController create(MatchesViewModel matchesViewModel, ViewManagerModel viewManagerModel, MatchesDataAccessInterface fileDataAccessObject) {
        MatchesOutputBoundary matchesPresenter = new MatchesPresenter(matchesViewModel, viewManagerModel);
        MatchesInputBoundary matchesInteractor = new MatchesInteractor(fileDataAccessObject, matchesPresenter);
        return new MatchesController(matchesInteractor);
    }

}
