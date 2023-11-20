package data_access;

import entity.UserFactory;
import entity.User;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRefreshRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import se.michaelthelin.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import se.michaelthelin.spotify.model_objects.specification.User;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class SpotifyDataAccessObject {
    private String clientId;
    private String clientSecret;
    private URI redirectURI;
    private String scope = "user-read-private user-read-email";
    private SpotifyApi spotifyApi;


    private UserFactory userFactory;

    public SpotifyDataAccessObject(UserFactory userFactory, String clientId, String clientSecret, URI redirectURI, String scope) {
        this.userFactory = userFactory;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectURI = redirectURI; // SpotifyHttpManager.makeUri("https://example.com/spotify-redirect");
        this.scope = scope;
        this.spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(redirectURI)
                .build();


    }

    public boolean signUpUser(User user) {

        if (!getAuthorizationCodeURI(user)) {
            return false;
        }
        if (!getAuthorizationTokens(user)) {
            return false;
        }

        GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile().build();

        try {
            se.michaelthelin.spotify.model_objects.specification.User spotifyUser = getCurrentUsersProfileRequest.execute();

            // get relevant user info for the sign up case
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return false;
        }

        return true;


    }



    public boolean refreshTokens(User user) {
        AuthorizationCodeRefreshRequest authorizationCodeRefreshRequest = spotifyApi.authorizationCodeRefresh()
                                                                          .build();
        try {
            final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRefreshRequest.execute();
            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());

            user.setRefreshTokenExpiry(authorizationCodeCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return false;
        }

        return true;

    }

    public boolean getAuthorizationTokens(User user) {

        AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(user.getURI().toString())
                                                            .build();

        try {
            final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();

            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

            user.setRefreshTokenExpiry(authorizationCodeCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return false;
        }

        return true;

    }

    public boolean getAuthorizationCodeURI(User user) {;

        AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
//          .state("x4xkmn9pu3j6ukrs8n")
//          .scope("user-read-birthdate,user-read-email")
//          .show_dialog(true)
                .build();


        final URI uri = authorizationCodeUriRequest.execute();
        user.setURI(uri);

        return true;

    }




}
