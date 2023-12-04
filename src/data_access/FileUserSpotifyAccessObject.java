package data_access;

import entity.User;
import entity.UserFactory;
import use_case.login.LogInUserDataAccessInterface;
import use_case.signup.SignUpSpotifyAccessInterface;
import use_case.signup.SignUpUserDataAccessInterface;

import java.io.*;
import java.util.*;

//TODO make sure to implement all required interfaces for this DAO
public class FileUserSpotifyAccessObject implements SignUpUserDataAccessInterface, LogInUserDataAccessInterface {

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, User> accounts = new HashMap<>();
    private UserFactory userFactory;

    public FileUserSpotifyAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);

        headers.put("username", 0);
        headers.put("birthdate", 1);
        headers.put("top_tracks", 2);
        headers.put("top_artists", 3);
        headers.put("top_genres", 4);
        // headers.put("creation time", 1); TODO: have to figure out if we need to keep track of creation time

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,email,birthdate,top_tracks,top_artists,top_genres");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String email = String.valueOf(col[headers.get("birthdate")]);
                    String birthdate = String.valueOf(col[headers.get("birthdate")]);
                    String topTracks = String.valueOf(col[headers.get("top_tracks")]);
                    String topArtists = String.valueOf(col[headers.get("top_artists")]);
                    String topGenres = String.valueOf(col[headers.get("top_genres")]);

                    // turn topTracks into an ArrayList of top tracks
                    String topTracksWithoutBrackets = topTracks.substring(1, topTracks.length() - 1);
                    String[] topTracksToIterate = topTracksWithoutBrackets.split(",");
                    ArrayList<String> topTrackArray = new ArrayList<String>(Arrays.asList(topTracksToIterate));

                    // turn topArtists into an ArrayList of top artists
                    String topArtistsWithoutBrackets = topArtists.substring(1, topArtists.length() - 1);
                    String[] topArtistsToIterate = topArtistsWithoutBrackets.split(",");
                    ArrayList<String> topArtistArray = new ArrayList<String>(Arrays.asList(topArtistsToIterate));

                    // turn topGenres into an ArrayList of top genres
                    String topGenresWithoutBrackets = topGenres.substring(1, topGenres.length() - 1);
                    String[] topGenresToIterate = topGenresWithoutBrackets.split(",");
                    ArrayList<String> topGenreArray = new ArrayList<String>(Arrays.asList(topGenresToIterate));

                    User user = userFactory.create(username, email, birthdate, topTrackArray, topArtistArray, topGenreArray);
                    accounts.put(username, user);
                }
            }
        }

    }

    public void save(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }
    public void deleteAccount(String username) {
        accounts.remove(username);
        this.save();
    }

    public User get(String username) {
        return accounts.get(username);
    }

    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    public boolean usersExist() {
        if (accounts.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s",
                        user.getName(), user.getEmail(), user.getBirthdate(), user.getTopTracks().toString(), user.getFavouriteArtists().toString(), user.getTopGenres().toString());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
