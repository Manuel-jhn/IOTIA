package com.example.iotia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class profil extends AppCompatActivity {

    ArrayList<Joueur> utilisateurs=new ArrayList<Joueur>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.profil);
        utilisateurs.add(new Joueur("Zidane","Zinedine","Zizou1998"));

       /* TextView text = new TextView(this);
        text.setText(R.string.app_name);
        setContentView(text);*/
    }
}