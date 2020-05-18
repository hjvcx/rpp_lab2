package com.example.aaaaaaaaa2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    private TextView test_text_view;
    private RequestQueue test_request_queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        test_text_view = findViewById(R.id.testTextView);
        Button test_button = findViewById(R.id.testButton);

        test_request_queue = Volley.newRequestQueue(this);

//        jsonParse();

        test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    public void jsonParse() {

        String url = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/techs.ruleset.json";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject obj = response.getJSONObject(i);

                                String flags = obj.optString("flags");
                                String graphic = obj.optString("graphic");
                                String graphic_alt = obj.optString("graphic_alt");
                                String helptext = obj.optString("helptext");
                                String name = obj.optString("name");
                                String req1 = obj.optString("req1");
                                String req2 = obj.optString("req2");

//                                arrayList.add(name+'\n'+graphic+'\n'+helptext);
                                test_text_view.append(graphic+" "+name+" "+helptext);

//                                contentClassArrayList.add(new ContentClass(flags, graphic, graphic_alt, helptext, name, req1, req2));
//                                contentClassArrayList.add(new ContentClass("", "", "", "", "", "", ""));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        test_request_queue.add(request);
    }
}

