package no.ntnu.stefhola.fantapp.model;

public class LoggedInUser {
    private String userId;
    private String token;

    public LoggedInUser(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return token;
    }
}
