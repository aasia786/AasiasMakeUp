package com.queen.aasiasmakeup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        appelServeur();
    }

    private void appelServeur() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/aasia786/AasiasMakeUp/feature/list/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MakeupAPI restApi = retrofit.create(MakeupAPI.class);

        Call<List<Products>> call = restApi.getProduct();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                if(response.isSuccessful()) {
                    List<Products> productsList = response.body();
                    displayList(productsList);
                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });
    }

    private void displayList(List<Products> productsList) {
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MakeUpAdapter(productsList, getAdapterListener(), this);
        recyclerView.setAdapter(mAdapter);
    }

    private MakeUpAdapter.OnItemClickListener getAdapterListener() {
        return new MakeUpAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Products item) {
                Gson gson = new Gson();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("key", gson.toJson(item));
                startActivity(intent);
            }
        };
    }
}
