package data_access;

import entity.User;
import entity.UserFactory;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRefreshRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistRequest;
import se.michaelthelin.spotify.requests.data.personalization.simplified.GetUsersTopArtistsRequest;
import se.michaelthelin.spotify.requests.data.personalization.simplified.GetUsersTopTracksRequest;
import se.michaelthelin.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;

import use_case.login.LogInSpotifyAccessInterface;
import use_case.get_auth_code.GetAuthCodeDataAccessInterface;
import use_case.signup.SignUpSpotifyAccessInterface;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class SpotifyDataAccessObject implements SignUpSpotifyAccessInterface, GetAuthCodeDataAccessInterface, LogInSpotifyAccessInterface {
    private String clientId;
    private String clientSecret;
    private URI redirectURI;
    private String scope;
    private SpotifyApi spotifyApi;
    private UserFactory userFactory;


    public SpotifyDataAccessObject(String clientId, String clientSecret, URI redirectURI, String scope, UserFactory userFactory) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectURI = redirectURI; // SpotifyHttpManager.makeUri("https://example.com/spotify-redirect");
        this.scope = scope;
        this.spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(redirectURI)
                .build();
        this.userFactory = userFactory;


    }
//TODO: add authorization code to parameter for signUpUser
    public User signUpUser(String authCode) {

        getAuthorizationTokens(authCode);

        GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile().build();

        try {
            se.michaelthelin.spotify.model_objects.specification.User spotifyUser = getCurrentUsersProfileRequest.execute();

            User user = userFactory.create(spotifyUser.getDisplayName());
            user.setBirthdate(spotifyUser.getBirthdate());
            getTopTracks(user);
            getTopArtistsAndGenres(user);

            return user;

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }


    }

    public void clearAuthorization() {
        spotifyApi.setAccessToken(null);
        spotifyApi.setRefreshToken(null);
    }
//TODO: add authorization code string attribute for the updateUserData method
    public void updateUserData(User user, String authCode) {
        getAuthorizationTokens(authCode);

        getTopTracks(user);
        getTopArtistsAndGenres(user);


    }

    private void getTopTracks(User user) {

        try {
            GetUsersTopTracksRequest getUsersTopTracksRequest = spotifyApi.getUsersTopTracks().build();
            Paging<Track> trackPaging = getUsersTopTracksRequest.execute();
            Track[] tracks = trackPaging.getItems();
            ArrayList<String> userTracks = new ArrayList<String>();

            for (int i = 0; i < 5; i++) {
                userTracks.add(tracks[i].toString());
            }

            user.setTopTracks(userTracks);

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }

    }

    private void getTopArtistsAndGenres(User user) {
        try {
            GetUsersTopArtistsRequest getUsersTopArtistsRequest = spotifyApi.getUsersTopArtists().build();
            Paging<Artist> artistPaging = getUsersTopArtistsRequest.execute();
            Artist[] artists = artistPaging.getItems();
            ArrayList<String> userArtists = new ArrayList<String>();
            ArrayList<String> userGenres = new ArrayList<String>();

            for (int i = 0; i < 5; i++) {
                String artistId = artists[i].getName();
                userGenres.add(getArtistGenre(artistId));
                userArtists.add(artists[i].toString());
            }

            user.setTopTracks(userArtists);
            user.setTopGenres(userGenres);

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }

    }



    private String getArtistGenre(String artistId) {

        GetArtistRequest getArtistRequest = spotifyApi.getArtist(artistId).build();
        try {
            final Artist artist = getArtistRequest.execute();

            return artist.getGenres()[0];
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
    }


/**
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

 **/

    private void getAuthorizationTokens(String authCode) {

        AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(authCode)
                                                            .build();

        try {
            final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();

            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

            // user.setRefreshTokenExpiry(authorizationCodeCredentials.getExpiresIn()); TODO: check whether needed
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public URI getAuthorizationCodeURI() {;

        AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
//          .state("x4xkmn9pu3j6ukrs8n")
            .scope("user-read-private,user-top-read,user-follow-read") // TODO take scope from Spotify API here
//          .show_dialog(true)
                .build();

        return authorizationCodeUriRequest.execute();

    }




}
