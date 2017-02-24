package exercises.net;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class MiniServer {

    private MiniServer() {
    }

    public static String sendRequest(String targetURL, String body) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Basic SFlCUklTNDcwOldnVXNBN3RC");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            connection.connect();

            //Send request
            DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
            wr.writeBytes(body);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
