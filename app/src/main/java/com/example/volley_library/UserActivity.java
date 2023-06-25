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

import MyAdapter.UserAdapter;
import MyAdapter.UserModel;

public class UserActivity extends AppCompatActivity {

    ArrayList<UserModel> list = new ArrayList<>();
    RecyclerView recyclerView;
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerView=findViewById(R.id.recyclerView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/users";
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
                                String name = mainObj.getString("name");
                                String username = mainObj.getString("username");
                                String phone = mainObj.getString("phone");
                                String company = mainObj.getString("company");
                                String website = mainObj.getString("website");
                                String address = mainObj.getString("address");
                                UserModel model = new UserModel(id,name,username,phone,company,website,address);
                                list.add(model);
                            }
                            adapter= new UserAdapter(UserActivity.this,list);
                            LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
                            manager.setOrientation(LinearLayoutManager.VERTICAL);
                            recyclerView.setLayoutManager(manager);
                            recyclerView.setAdapter(adapter);
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