package com.example.volley_library;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Interface {
    @GET("api/get_regular_category?user_id=233")
    Call<DataModel> getAllData();
}