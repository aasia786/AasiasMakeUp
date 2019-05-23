package com.queen.aasiasmakeup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("key");
        Products products = gson.fromJson(strObj, Products.class);
    }
}
