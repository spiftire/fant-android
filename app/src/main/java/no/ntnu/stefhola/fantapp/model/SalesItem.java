package no.ntnu.stefhola.fantapp.model;

import android.media.Image;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SalesItem {
    private static final String TAG = SalesItem.class.getSimpleName();
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String IMAGES = "images";
    private static final String BUYER = "buyer";
    private static final String URL = "url";


    long id;
    String title;
    String description;
    BigInteger price;
    Timestamp version;
    List<String> images = new ArrayList<>();
    User seller;
    User buyer;

    public SalesItem(JSONObject jsonObject) {
        try {
            setId(Long.parseLong(jsonObject.getString("id")));
            setTitle(jsonObject.getString(TITLE));
            setDescription(jsonObject.getString(DESCRIPTION));
            setPrice(new BigInteger(jsonObject.getString(PRICE)));

            if (jsonObject.has(IMAGES)) {
                JSONArray images = jsonObject.getJSONArray(IMAGES);
                for (int i = 0; i < images.length(); i++) {
                    JSONObject image = images.getJSONObject(i);
                    this.images.add(image.getString(URL));
                }
            }

            if (jsonObject.has(BUYER)) {
                setBuyer(new User(jsonObject.getJSONObject(BUYER)));
            }

        } catch (JSONException ex) {
            Log.d(TAG, "Trying to create a sales item from json object failed" +
                    ex.getMessage());
        }
    }
}
