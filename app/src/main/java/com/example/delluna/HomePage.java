package com.example.delluna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.delluna.adapter.ImageAdapter;

public class HomePage extends AppCompatActivity {

    TextView TV_Welcome;
    Bundle Extras;
    Button btnLookItem;

    ViewPager vpImage;
    ImageAdapter imageAdapter;

    void init () {
        TV_Welcome = findViewById(R.id.TV_Welcome);
        btnLookItem = findViewById(R.id.BTN_lookitem);
        Extras = getIntent().getExtras();

        setUsername();

        btnLookItem.setOnClickListener(e->{
            Intent intent = new Intent(this, ItemPage.class);
            startActivity(intent);
            finish();
        });
    }

    void setUsername () {
        String username = Extras.getString("username");
        TV_Welcome.setText(username);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        init();

        //imageSlide
        vpImage = findViewById(R.id.VP_imgSlide);
        imageAdapter = new ImageAdapter(this);
        vpImage.setAdapter(imageAdapter);
    }
}