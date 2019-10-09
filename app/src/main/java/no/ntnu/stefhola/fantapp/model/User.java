package no.ntnu.stefhola.fantapp.model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class User {
    private static final String TAG = User.class.getSimpleName();
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";


    String username;
    String firstname;
    String lastname;
    String email;

    public User(JSONObject jsonObject) {
        try {
            if (jsonObject.has(FIRSTNAME)
                    && jsonObject.has(LASTNAME)
                    && jsonObject.has(USERNAME)
                    && jsonObject.has(EMAIL)) {
                setFirstname(jsonObject.getString(FIRSTNAME));
                setLastname(jsonObject.getString(LASTNAME));
                setUsername(jsonObject.getString(USERNAME));
                setEmail(jsonObject.getString(EMAIL));
            }
            else {
                Log.d(TAG, "Trying to create a user form json failed. JsonObject: " +
                        jsonObject.toString());
            }
        } catch (JSONException ex) {
            Log.d(TAG, "Trying to create a user form json failed. " +
                    jsonObject.toString() + " " +
                    ex.getMessage());
        }
    }
}
