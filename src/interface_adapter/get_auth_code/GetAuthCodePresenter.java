package interface_adapter.get_auth_code;

import use_case.get_auth_code.GetAuthCodeOutputBoundary;
import use_case.get_auth_code.GetAuthCodeOutputData;

public class GetAuthCodePresenter implements GetAuthCodeOutputBoundary {

    private final GetAuthCodeViewModel getAuthCodeViewModel;

    public GetAuthCodePresenter(GetAuthCodeViewModel getAuthCodeViewModel) {
        this.getAuthCodeViewModel = getAuthCodeViewModel;
    }


    @Override
    public void prepareSuccessView(GetAuthCodeOutputData getAuthCodeOutputData) {
        GetAuthCodeState getAuthCodeState = this.getAuthCodeViewModel.getState();
        getAuthCodeState.setSuccess(getAuthCodeOutputData);
        getAuthCodeViewModel.firePropertyChanged();

    }
}
