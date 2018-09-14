package com.codzunk.recycode.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.codzunk.recycode.R;
import com.codzunk.recycode.adapter.RecycViewPagerAdapter;
import com.codzunk.recycode.advert.AdService;
import com.codzunk.recycode.data.DataManager;
import com.google.android.gms.ads.AdView;

public class FullscreenActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private AdService adService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        DataManager manager = new DataManager(this);
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
        RecycViewPagerAdapter pagerAdapter = new RecycViewPagerAdapter(manager.getResources());
        pagerAdapter.setOnCheckedChangeListener(onCheckedChangeListener);
        viewPager.setAdapter(pagerAdapter);
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

    private RecycViewPagerAdapter.OnCheckedChangeListener onCheckedChangeListener =
            new RecycViewPagerAdapter.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton button, boolean isChecked) {
            if (isChecked){
                Toast.makeText(FullscreenActivity.this, "Play", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(FullscreenActivity.this, "Stop", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
