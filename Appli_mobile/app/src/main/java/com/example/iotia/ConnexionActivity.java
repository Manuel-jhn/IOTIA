package com.example.iotia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_connexion);
    }
}