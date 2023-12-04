package use_case.delete_account;

import data_access.FileUserSpotifyAccessObject;
import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.User;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteAccountInteractorTest {
    void successTest() {
        DeleteAccountDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        CommonUserFactory userFactory = new CommonUserFactory();
        User user = userFactory.create("Mila");
        userRepository.save(user);
        DeleteAccountOutputBoundary successPresenter = new DeleteAccountOutputBoundary() {
            @Override
            public void prepareDeletedAccountView(DeleteAccountOutputData user) {
                assertEquals("Mila", user.getDeletedUser());
                assertFalse(userRepository.existsByName("Mila"));
            }
        };
        DeleteAccountInputData inputData = new DeleteAccountInputData("Mila");
        DeleteAccountInputBoundary interactor = new DeleteAccountInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

}

