package interface_adapter.back;

import use_case.back.BackInputBoundary;

public class BackController {
    final BackInputBoundary backUseCaseInteractor;
    public BackController(BackInputBoundary backUseCaseInteractor) {
        this.backUseCaseInteractor = backUseCaseInteractor;
    }
    public void execute() {
        backUseCaseInteractor.execute();
    }
}
