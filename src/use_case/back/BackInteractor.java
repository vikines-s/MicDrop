package use_case.back;

public class BackInteractor implements BackInputBoundary {
    final BackOutputBoundary userPresenter;
    public BackInteractor(BackOutputBoundary userPresenter) {
        this.userPresenter = userPresenter;
    }
    public void execute() {
        userPresenter.prepareSuccessView();
    }
}
