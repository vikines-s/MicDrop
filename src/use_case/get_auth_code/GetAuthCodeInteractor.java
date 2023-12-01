package use_case.get_auth_code;

public class GetAuthCodeInteractor implements GetAuthCodeInputBoundary {

    final GetAuthCodeDataAccessInterface spotifyDataAccessObject;
    final GetAuthCodeOutputBoundary getAuthCodePresenter;

    public GetAuthCodeInteractor(GetAuthCodeDataAccessInterface spotifyDataAccessObject, GetAuthCodeOutputBoundary getAuthCodePresenter) {
        this.spotifyDataAccessObject = spotifyDataAccessObject;
        this.getAuthCodePresenter = getAuthCodePresenter;
    }

    @Override
    public void execute() {

    }
}
