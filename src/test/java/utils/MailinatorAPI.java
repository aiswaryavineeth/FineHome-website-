package utils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MailinatorAPI {
    private static final String MAILINATOR_API_URL = "https://api.mailinator.com/api/v2";

    public static String getOTP(String email) {
        try {
            // Mailinator API endpoint to fetch inbox emails
            String inboxUrl = MAILINATOR_API_URL + "/inbox?to=" + email;

            // Make the request to Mailinator API to fetch emails for the given email address
            HttpURLConnection connection = (HttpURLConnection) new URL(inboxUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer YOUR_API_KEY"); // Add API key

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the response (Assuming JSON format) to find the email containing OTP
            JSONArray messages = new JSONObject(response.toString()).getJSONArray("messages");
            if (messages.length() > 0) {
                // Get the first message
                JSONObject message = messages.getJSONObject(0);

                // Get the email ID to fetch the actual email content (may need to make another request to fetch the full email)
                String messageId = message.getString("id");

                // Fetch full email using message ID
                String messageContentUrl = MAILINATOR_API_URL + "/message/" + messageId;
                HttpURLConnection messageConnection = (HttpURLConnection) new URL(messageContentUrl).openConnection();
                messageConnection.setRequestMethod("GET");
                messageConnection.setRequestProperty("Authorization", "Bearer YOUR_API_KEY");

                // Read the email content
                BufferedReader emailIn = new BufferedReader(new InputStreamReader(messageConnection.getInputStream()));
                StringBuilder emailResponse = new StringBuilder();
                while ((inputLine = emailIn.readLine()) != null) {
                    emailResponse.append(inputLine);
                }
                emailIn.close();

                // Parse the email content to extract the OTP
                JSONObject email1 = new JSONObject(emailResponse.toString());
                String emailBody = email1.getString("body");

                // Assuming OTP is a 6-digit number within the email body
                String otp = extractOTP(emailBody);
                return otp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if OTP not found
    }

    // Helper function to extract OTP (simplified regex for 6 digits)
    private static String extractOTP(String body) {
        String regex = "\\b\\d{6}\\b"; // Match 6-digit numbers
        return body.replaceAll(regex, "$0"); // Returns first match
    }
}
