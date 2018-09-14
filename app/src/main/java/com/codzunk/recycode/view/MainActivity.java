package com.codzunk.recycode.view;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.codzunk.recycode.R;
import com.codzunk.recycode.adapter.RecycAdapter;
import com.codzunk.recycode.data.DataManager;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static android.view.View.X;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataManager dataManager = new DataManager(this);
        dataManager.loadResources();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recycView);
        recyclerView.setNestedScrollingEnabled(false);
        GridLayoutManager manager = new GridLayoutManager(this, 2){
            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(MainActivity.this) {

                    private static final float SPEED = 300f;

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }

                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }
        };
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new RecycAdapter(dataManager.getResources(), recycOnClickListener));


    }

    private RecycAdapter.RecycOnClickListener recycOnClickListener = new RecycAdapter.RecycOnClickListener() {
        @Override
        public void onClick(View view, int position) {
            startActivity(new Intent(MainActivity.this, FullscreenActivity.class)
                    .putExtra("position", position));
        }
    };
}
