package use_case.signup;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.User;
import use_case.login.*;

import static org.junit.jupiter.api.Assertions.*;

public class SignUpInteractorTest {
    void successTest() {
        SignUpUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        SignUpSpotifyAccessInterface spotifyRepository = new InMemoryUserDataAccessObject();
        SignUpOutputBoundary successPresenter = new SignUpOutputBoundary() {
            @Override
            public void prepareSuccessView(SignUpOutputData user) {
                assertEquals(user.getUser().getName(), "Mila");
                assertTrue(userRepository.existsByName("Mila"));
                assertFalse(user.isSignUpFailed());
            }
            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }
        };
        SignUpInputData inputData = new SignUpInputData("Mila", "123");
        SignUpInteractor interactor = new SignUpInteractor(spotifyRepository, userRepository, successPresenter);
        interactor.execute(inputData);
    }
}