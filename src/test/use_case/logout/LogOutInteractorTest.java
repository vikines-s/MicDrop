package test.use_case.logout;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.User;
import use_case.delete_account.*;
import use_case.logout.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LogOutInteractorTest {
    void successTest() {
        LogOutDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        CommonUserFactory userFactory = new CommonUserFactory();
        User user = userFactory.create("Mila");
        ((InMemoryUserDataAccessObject) userRepository).save(user);
        LogOutOutputBoundary successPresenter = new LogOutOutputBoundary() {
            @Override
            public void prepareLogoutView(LogOutOutputData logOutOutputData) {
                assertEquals(logOutOutputData.getUsername(), "Mila");
            }
        };
        LogOutInputData inputData = new LogOutInputData("Mila");
        LogOutInputBoundary interactor = new LogOutInteractor(successPresenter, userRepository);
        interactor.execute(inputData);
    }
}
