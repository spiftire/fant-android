package no.ntnu.stefhola.fantapp.data;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import no.ntnu.stefhola.fantapp.model.LoggedInUser;

public class LoginDataSource {
    public static final String URL_TO_SERVER = "http://"; //todo host server on auto deploy.
    public static final String CHARSET = "UTF-8";
    public static final String TAG = "LoginDataSource";

    public Result<LoggedInUser> login(String username, String password) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(URL_TO_SERVER + "/api/auth/login?uid=" + username + "&pwd=" + password);
            connection = (HttpURLConnection) url.openConnection();
            connection.setUseCaches(true);
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), CHARSET));
                String token = bufferedReader.readLine();
                Log.d(TAG, "Request successfull. Token: " + token);
                LoggedInUser fakeUser = new LoggedInUser(username, token);
                connection.getInputStream().close();
                return new Result.Success<>(fakeUser);
            }
            return new Result.Error(new IOException("Error loggin in " + connection.getResponseMessage()));
        }
        catch (Exception e) {
            Log.d(TAG, "Failed to call " + e);
            return new Result.Error(new IOException("Error logging in", e));
        }
        finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
