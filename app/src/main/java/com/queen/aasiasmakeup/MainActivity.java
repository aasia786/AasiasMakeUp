package com.queen.aasiasmakeup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnQueen = findViewById(R.id.btn_second_ecran);

        btnQueen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               launchSecondScreen();
            }
        });


        String toto = "toto";
    }

    private void launchSecondScreen() {
        Intent intent = new Intent(getBaseContext(), SecondActivity.class);
        startActivity(intent);
    }
}
