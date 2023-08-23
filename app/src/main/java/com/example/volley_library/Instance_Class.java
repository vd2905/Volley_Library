package com.example.volley_library;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Instance_Class {
    public static Instance_Class instance;
    Api_Interface api_interface;

    Instance_Class(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://customise.freaktemplate.com/homeworkout/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api_interface = retrofit.create(Api_Interface.class);
    }

    public static Instance_Class getInstance() {
        if(instance == null)
        {
            instance = new Instance_Class();
        }
        return instance;
    }
}
