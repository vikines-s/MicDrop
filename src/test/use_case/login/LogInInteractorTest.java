package use_case.login;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUser;
import entity.CommonUserFactory;
import entity.User;
import use_case.delete_account.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LogInInteractorTest {
    void successTest() {
        LogInUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        LogInSpotifyAccessInterface spotifyRepository = new InMemoryUserDataAccessObject();
        CommonUserFactory userFactory = new CommonUserFactory();
        User user = userFactory.create("Mila");
        userRepository.save(user);
        LogInOutputBoundary successPresenter = new LogInOutputBoundary() {
            @Override
            public void prepareSuccessView(LogInOutputData user) {
                assertEquals(user.getUsername(), "Mila");
                assertEquals(user.getTopTracks(), "hi");
                assertEquals(user.getTopArtists(), "hi");
                assertEquals(user.getTopGenres(), "hi");
            }
            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }
        };
        LogInInputData inputData = new LogInInputData("Mila", "123");
        LogInInputBoundary interactor = new LogInInteractor(userRepository, spotifyRepository, successPresenter);
        interactor.execute(inputData);
    }
}
