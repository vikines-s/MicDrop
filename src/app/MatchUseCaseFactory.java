package app;

import interface_adapter.ViewManagerModel;

public class MatchUseCaseFactory {
    private MatchUseCaseFactory() {}
    public static MatchController create(MatchViewModel matchAccountViewModel,
                                                 matcnDataAccessInterface userDataAccessObject,
                                                 MatchViewModel matchViewModel, ViewManagerModel viewManagerModel) {
        MatchOutputBoundary matchAccountOutputBoundary = new MatchPresenter(signUpViewModel, deleteAccountViewModel, viewManagerModel);
        MatchInputBoundary matchAccountInteractor = new MatchInteractor(userDataAccessObject, matchAccountOutputBoundary);
        return new MatchController(matchInteractor);
    }
}
