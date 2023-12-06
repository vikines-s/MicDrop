package test.use_case.matches;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.User;
import use_case.delete_account.*;
import use_case.matches.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MatchesInteractorTest {
    void successTest() {
        MatchesDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        CommonUserFactory userFactory = new CommonUserFactory();
        ArrayList<String> tracks = new ArrayList<>();
        tracks.add("One Dance");
        tracks.add("Snooze");
        tracks.add("my.life");
        tracks.add("Mistletoe");
        tracks.add("Sprinter");
        User user = userFactory.create("Mila", "mila.bhaloo@mail.utoronto.ca", "May", tracks, tracks, tracks);
        ((InMemoryUserDataAccessObject) userRepository).save(user);
        User user2 = userFactory.create("Kam", "kam@mail.utoronto.ca", "March", tracks, tracks, tracks);
        ((InMemoryUserDataAccessObject) userRepository).save(user2);
        MatchesOutputBoundary successPresenter = new MatchesOutputBoundary() {
            @Override
            public void prepareSuccessView(MatchesOutputData matchesOutputData) {
                assertEquals(matchesOutputData.getMatch1(), "Match 1:\n# of matching tracks : 5\nUser's email: kam@mail.utoronto.ca");
                assertEquals(matchesOutputData.getMatch2(), "");
                assertEquals(matchesOutputData.getMatch3(), "");
                assertEquals(matchesOutputData.getMatch4(), "");
                assertEquals(matchesOutputData.getMatch5(), "");
                assertEquals(matchesOutputData.getMatchType(), "tracks");
            }
            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }
        };
        MatchesInputData inputData = new MatchesInputData("Mila", new TracksAlgorithm());
        MatchesInputBoundary interactor = new MatchesInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }
}
