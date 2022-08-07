package com.example.delluna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.delluna.adapter.Image;
import com.example.delluna.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    TextView TV_Welcome;
    Bundle Extras;
    Button btnLookItem, btnImageNext, btnImagePrevious;

    ViewPager2 viewPager2;
    List<Image> images;
    ImageAdapter imageAdapter;
    Handler sliderHandler = new Handler();
    int index;

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
        viewPager2 = findViewById(R.id.VP_imgSlide);
        images = new ArrayList<>();

        images.add(new Image(R.drawable.slide1));
        images.add(new Image(R.drawable.slide2));
        images.add(new Image(R.drawable.slide3));
        images.add(new Image(R.drawable.slide4));
        images.add(new Image(R.drawable.slide5));

        imageAdapter = new ImageAdapter(images, viewPager2);
        viewPager2.setAdapter(imageAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 5000);
            }
        });

        //next and prev button
        initButtons();
    }

    public void initButtons(){
        index=0;
        btnImageNext = findViewById(R.id.BTN_imageNext);
        btnImagePrevious = findViewById(R.id.BTN_imagePrevious);

        btnImageNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

        btnImagePrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();
            }
        });
    }

    public void next(){
        index++;
        if(index>=imageAdapter.getItemCount()) index=0;
        viewPager2.setCurrentItem(index);
    }

    public void prev(){
        if(index<=0) index=imageAdapter.getItemCount();
        else index--;
        viewPager2.setCurrentItem(index);
    }


    public Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };

}