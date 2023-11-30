
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class spotifyAPI {
    public static void main(String[] args) {
        String accessToken = "BQBfLzP2ACrM3_aKjdNKJxN-egiGsQqDkgmJJ9QCUY0ZaUQOoSOdouhKcGiDsjSoW3P_nktNurTaefLg39moT9wzrU4OUJbUekdoyK16Mxe5vDc-RCsaxWbzkm2cROMTl8onV5QzvMLeFlXkrkBJY1H8_lQU8k782SZPvy7ik0KhnsKnExg";
        String endpoint = "https://api.spotify.com/v1/me";
        try {
            // Create a URL object for the Spotify API endpoint
            URL url = new URL(endpoint);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Set the Authorization header with the access token
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Request was successful, read and display the user information
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                System.out.println("User Information:");
                System.out.println(response.toString());
            } else {
                // Handle error response (e.g., invalid token, unauthorized)
                System.out.println("Error: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
