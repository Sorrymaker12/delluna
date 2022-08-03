package com.example.delluna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView TV_Welcome;
    Bundle Extras;

    void init () {
        TV_Welcome = findViewById(R.id.TV_Welcome);
        Extras = getIntent().getExtras();

        setUsername();
    }

    void setUsername () {
        String username = Extras.getString("username");
        TV_Welcome.setText("Welcome, " + username);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        init();
    }
}