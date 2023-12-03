package app;

import data_access.FileUserSpotifyAccessObject;
import data_access.SpotifyDataAccessObject;
import entity.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_auth_code.GetAuthCodeController;
import interface_adapter.get_auth_code.GetAuthCodeViewModel;
import interface_adapter.login.LogInViewModel;
import interface_adapter.login.LogInController;
import interface_adapter.signup.SignUpController;
import interface_adapter.signup.SignUpViewModel;;
import se.michaelthelin.spotify.SpotifyHttpManager;
import view.SignupLoginView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException { // TODO: take away URISyntaxException from here at some point
        JFrame application = new JFrame("MicDrop");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        SignUpViewModel signUpViewModel = new SignUpViewModel();
        LogInViewModel loginViewModel = new LogInViewModel();
        GetAuthCodeViewModel getAuthCodeViewModel = new GetAuthCodeViewModel();
        // TODO: ADD THE OTHER VIEW MODELS ONCE WE FINISH THEM / FINISH TEST

        FileUserSpotifyAccessObject fileUserDataAccessObject;
        SpotifyDataAccessObject spotifyDataAccessObject;
        CommonUserFactory userFactory = new CommonUserFactory();

        try {
            fileUserDataAccessObject = new FileUserSpotifyAccessObject("users.csv", userFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String CLIENT_ID = "4bd4b40ba79042e882aad0141ba5dfe6";
        String CLIENT_SECRET = "86efef17dc4b419c8406531ac943b84a";
        URI REDIRECT_URI = SpotifyHttpManager.makeUri("http://localhost:8888/callback"); // new URI("http://localhost:3000")
        String SCOPE = "user-read-private,user-top-read,user-follow-read";
        spotifyDataAccessObject = new SpotifyDataAccessObject(CLIENT_ID, CLIENT_SECRET, REDIRECT_URI, SCOPE, userFactory);

        GetAuthCodeController getAuthCodeController = GetAuthCodeUseCaseFactory.createGetAuthCodeUseCase(getAuthCodeViewModel, spotifyDataAccessObject);
//TODO: login use case factory needed
        SignupLoginView signupLoginView = SignUpUseCaseFactory.create(viewManagerModel, loginViewModel, signUpViewModel, getAuthCodeViewModel, new LogInController(), getAuthCodeController, fileUserDataAccessObject, spotifyDataAccessObject);
        views.add(signupLoginView);

        viewManagerModel.setActiveView(signupLoginView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}
