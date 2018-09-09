package com.codzunk.recycode.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.codzunk.recycode.R;
import com.codzunk.recycode.adapter.RecycViewPagerAdapter;
import com.codzunk.recycode.advert.AdService;
import com.codzunk.recycode.data.DataManager;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class FullscreenActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private AdService adService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        DataManager manager = new DataManager();
        manager.loadResources();

        int position = getIntent().getIntExtra("position", 0);

        // adView
        AdView adView = findViewById(R.id.adView);
        adService = new AdService(this);
        adService.initBanner(adView);

        // adding toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new RecycViewPagerAdapter(manager.getResources()));
        viewPager.setCurrentItem(position);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position % 3 == 0){
            adService.initInterstitialAd(this);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
