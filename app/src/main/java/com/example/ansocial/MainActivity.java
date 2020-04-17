package com.example.ansocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {


    private static int SPLASH_SCREEN_TIME_OUT = 4000;


    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent signInIntent = new Intent(MainActivity.this, FirebaseUIActivity.class);
                startActivity(signInIntent);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);

    }




}

