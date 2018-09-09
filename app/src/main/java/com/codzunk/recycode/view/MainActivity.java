package com.codzunk.recycode.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.codzunk.recycode.R;
import com.codzunk.recycode.adapter.RecycAdapter;
import com.codzunk.recycode.data.DataManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataManager dataManager = new DataManager();
        dataManager.loadResources();

        RecyclerView recyclerView = findViewById(R.id.recycView);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new RecycAdapter(dataManager.getResources(), recycOnClickListener));
    }

    private RecycAdapter.RecycOnClickListener recycOnClickListener = new RecycAdapter.RecycOnClickListener() {
        @Override
        public void onClick(View view, int position) {
            startActivity(new Intent(MainActivity.this, FullscreenActivity.class).putExtra("position", position));
        }
    };
}
