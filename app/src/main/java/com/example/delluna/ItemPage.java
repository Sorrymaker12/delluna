package com.example.delluna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ItemPage extends AppCompatActivity {

    TabLayout tlTab;
    ViewPager2 vpFragment;

    void init() {
        tlTab = findViewById(R.id.tlTab);
        vpFragment = findViewById(R.id.vpFragment);
    }

    void populateTab() {
        tlTab.addTab(tlTab.newTab().setText("Cloth"));
        tlTab.addTab(tlTab.newTab().setText("Album"));
        tlTab.addTab(tlTab.newTab().setText("Other"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);

        init();
        populateTab();
    }
}