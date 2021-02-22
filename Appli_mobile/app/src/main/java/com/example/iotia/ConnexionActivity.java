package com.example.iotia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_connexion);

        Button next = (Button) findViewById(R.id.btn_Connexion);
        EditText getnom=(EditText) findViewById(R.id.nom);
        final String nom=getnom.getText().toString();
        EditText getprenom=(EditText) findViewById(R.id.prenom);
        final String prenom=getnom.getText().toString();
        EditText getmdp=(EditText) findViewById(R.id.Password);
        final String mdp=getnom.getText().toString();
        EditText getconfirm=(EditText) findViewById(R.id.ConfirmPassword);
        final String confirm=getconfirm.getText().toString();

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), profil.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button versInscri = (Button) findViewById(R.id.btn_versInscri);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    Joueur j=new Joueur(nom,prenom,mdp);
                    Intent myIntent = new Intent(view.getContext(), profil.class);
                    startActivityForResult(myIntent, 0);
            }

        });
    }
}