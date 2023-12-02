package app;

import interface_adapter.get_auth_code.GetAuthCodeController;
import interface_adapter.get_auth_code.GetAuthCodePresenter;
import interface_adapter.get_auth_code.GetAuthCodeViewModel;
import use_case.get_auth_code.GetAuthCodeDataAccessInterface;
import use_case.get_auth_code.GetAuthCodeInputBoundary;
import use_case.get_auth_code.GetAuthCodeInteractor;
import use_case.get_auth_code.GetAuthCodeOutputBoundary;

public class GetAuthCodeUseCaseFactory {

    private GetAuthCodeUseCaseFactory() {}

    public static GetAuthCodeController createGetAuthCodeUseCase(GetAuthCodeViewModel getAuthCodeViewModel, GetAuthCodeDataAccessInterface spotifyDataAccessObject) {
        GetAuthCodeOutputBoundary getAuthCodeOutputBoundary = new GetAuthCodePresenter(getAuthCodeViewModel);
        GetAuthCodeInputBoundary getAuthCodeInputBoundary = new GetAuthCodeInteractor(spotifyDataAccessObject, getAuthCodeOutputBoundary);
        return new GetAuthCodeController(getAuthCodeInputBoundary);
    }
}
