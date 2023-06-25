package com.example.volley_library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import MyAdapter.PhotoAdapter;
import MyAdapter.PhotoModel;

public class PhotoActivity extends AppCompatActivity {

    ArrayList<PhotoModel> list1 = new ArrayList<>();
    RecyclerView recyclerView1;
    PhotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        recyclerView1=findViewById(R.id.recyclerView1);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/photos";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray jsonArray=null;

                        try {
                            jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                JSONObject mainObj=jsonArray.getJSONObject(i);
                                int id = mainObj.getInt("id");
                                String title = mainObj.getString("title");
                                String thumbnailUrl = mainObj.getString("thumbnailUrl");
                                PhotoModel photoModel = new PhotoModel(id,title,thumbnailUrl);
                                list1.add(photoModel);
                            }

                            adapter= new PhotoAdapter(PhotoActivity.this,list1);
                            LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
                            manager.setOrientation(LinearLayoutManager.VERTICAL);
                            recyclerView1.setLayoutManager(manager);
                            recyclerView1.setAdapter(adapter);
                        }
                        catch (JSONException e)
                        {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("VVV", "onErrorResponse: "+error.getLocalizedMessage());
            }
        });
        queue.add(stringRequest);
    }

}