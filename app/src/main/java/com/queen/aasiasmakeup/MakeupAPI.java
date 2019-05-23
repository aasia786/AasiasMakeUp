package com.queen.aasiasmakeup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MakeupAPI {
    @GET("data.json")
    Call<List<Products>> getProduct();
}