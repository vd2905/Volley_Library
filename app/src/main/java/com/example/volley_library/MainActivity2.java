package com.example.volley_library;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    private Button btnGetData;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnGetData = findViewById(R.id.btnGetData);
        listView = findViewById(R.id.listviewData);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Instance_Class.getInstance().api_interface.getAllData().enqueue(new Callback<DataModel>() {
                    @Override
                    public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                        Log.e("TTT", "onResponse: "+response);
                        ArrayList <DataModel.Create> list = response.body().getData().getCreate();
                        String[] names = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            names[i] = "cat_name : " + list.get(i).getCatName() + "\ncat_type : " + list.get(i).getCatType() + "\nshort_desc : " + list.get(i).getShortDesc();
                        }
                        listView.setAdapter(new ArrayAdapter < String > (getApplicationContext(), android.R.layout.simple_list_item_1, names));
                    }

                    @Override
                    public void onFailure(Call<DataModel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "An error has occur", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}