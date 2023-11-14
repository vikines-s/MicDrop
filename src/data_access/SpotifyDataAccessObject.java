package data_access;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.model_objects.specification.User;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

public class SpotifyDataAccessObject {
    private static final String clientId = "YOUR_CLIENT_ID";
    private static final String clientSecret = "YOUR_CLIENT_SECRET";
    private static final String redirectUri = "YOUR_REDIRECT_URI";
    private static final String scope = "user-read-private user-read-email"; // Add the necessary scopes

    public static void main(String[] args) {
        // Step 1: Get Authorization Code by directing the user to Spotify authorization endpoint
        String authorizationCode = getAuthorizationCodeUri();

        // After the user grants permission, they will be redirected to the provided redirect URI
        // Extract the authorization code from the redirect URI

        // Step 2: Exchange Authorization Code for Access Token
        AuthorizationCodeCredentials credentials = exchangeAuthorizationCodeForAccessToken(authorizationCode);

        // Use the access token to make requests to the Spotify API
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(credentials.getAccessToken())
                .build();

        // Example: Get the user's information
        getUserInfo(spotifyApi);
    }

    private static String getAuthorizationCodeUri() {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(URI.create(redirectUri))
                .build();

        AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
                .scope(scope)
                .build();

        URI uri = authorizationCodeUriRequest.execute();
        System.out.println("Please visit the following URL to authorize the application:");
        System.out.println(uri);
        return getAuthorizationCodeFromUser();
    }

    private static String getAuthorizationCodeFromUser() {
        // After the user grants permission, they will be redirected to the provided redirect URI
        // Extract the authorization code from the redirect URI
        System.out.print("Enter the authorization code: ");
        // Read user input or use your preferred method to get the authorization code
        return ""; // Replace with your code to get user input
    }

    private static AuthorizationCodeCredentials exchangeAuthorizationCodeForAccessToken(String authorizationCode) {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(URI.create(redirectUri))
                .build();

        AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(authorizationCode)
                .build();

        try {
            return authorizationCodeRequest.execute();
        } catch (CompletionException | CancellationException | IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error exchanging authorization code for access token: " + e.getMessage());
            return null;
        }
    }

    private static void getUserInfo(SpotifyApi spotifyApi) {
        try {
            CompletableFuture<User> userFuture = spotifyApi.getCurrentUsersProfile()
                    .build()
                    .executeAsync();

            // Wait for the user information to be retrieved
            User user = userFuture.join();

            // Now you can use the user information as needed
            System.out.println("User ID: " + user.getId());
            System.out.println("Display Name: " + user.getDisplayName());
            System.out.println("Email: " + user.getEmail());
        } catch (Exception e) {
            System.out.println("Error getting user information: " + e.getMessage());
        }
    }
}
