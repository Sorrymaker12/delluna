package com.example.delluna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ItemPage extends AppCompatActivity {

    TabLayout tlTab;
    ViewPager2 vpFragment;
    FragmentAdapter fragmentAdapter;

    void init() {
        tlTab = findViewById(R.id.tlTab);
        vpFragment = findViewById(R.id.vpFragment);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        vpFragment.setAdapter(fragmentAdapter);
    }

    void populateTab() {
        tlTab.addTab(tlTab.newTab().setText("Cloth"));
        tlTab.addTab(tlTab.newTab().setText("Album"));
        tlTab.addTab(tlTab.newTab().setText("Other"));
    }

    void setupTab() {
        tlTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpFragment.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);

        init();
        populateTab();
        setupTab();
    }
}