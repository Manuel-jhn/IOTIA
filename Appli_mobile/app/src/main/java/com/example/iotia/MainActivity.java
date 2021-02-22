package com.example.iotia;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Button versProfil = (Button) findViewById(R.id.btn_inscription);
        versProfil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), profil.class);
                startActivityForResult(myIntent, 0);
            }

        });

       /* TextView text = new TextView(this);
        text.setText(R.string.app_name);
        setContentView(text);*/
    }
}