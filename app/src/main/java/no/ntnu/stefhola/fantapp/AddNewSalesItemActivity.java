package no.ntnu.stefhola.fantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddNewSalesItemActivity extends AppCompatActivity {

    public static final String TAG = AddNewSalesItemActivity.class.getSimpleName();
    Button submit = findViewById(R.id.submit_button);
    Button cancel;
    EditText title = (EditText) findViewById(R.id.title_input);
    EditText price = (EditText) findViewById(R.id.price_input);
    EditText description;

    RequestQueue requestQueue = Volley.newRequestQueue(this);
    public static final String POST_URL = "http://XXX.com/api/salesItem"; // todo make this a proper link

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_sales_item);

        addButtonEventListeners();
    }

    private void addButtonEventListeners() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleString = title.getText().toString();
                int priceInt = Integer.parseInt(price.getText().toString());
                String descriptionString = description.getText().toString();

                try {
                    JSONObject request = new JSONObject();
                    request.put("title", titleString);
                    request.put("price", priceInt);
                    request.put("description", descriptionString);
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                            Request.Method.POST, POST_URL, request, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d(TAG, "Got response: " + response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(TAG, "The response did not go through" + error.getMessage());
                        }
                    });

                    requestQueue.add(jsonObjectRequest);
                } catch (JSONException ex) {
                    Log.d(TAG, ex.getMessage());
                }
            }
        });
    }
}
