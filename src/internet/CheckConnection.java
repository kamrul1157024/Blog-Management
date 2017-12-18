package internet;

import java.net.*;

public class CheckConnection{

    public CheckConnection() {
    }

    public boolean IsConnected() {

        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}

