package interface_adapter.get_auth_code;

import use_case.get_auth_code.GetAuthCodeInputBoundary;

public class GetAuthCodeController {

    final GetAuthCodeInputBoundary getAuthCodeInteractor;

    public GetAuthCodeController(GetAuthCodeInputBoundary getAuthCodeInteractor) {
        this.getAuthCodeInteractor = getAuthCodeInteractor;
    }
    public void execute() {
        this.getAuthCodeInteractor.execute();
    }
}
