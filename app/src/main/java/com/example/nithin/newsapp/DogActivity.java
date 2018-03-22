package com.example.nithin.newsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DogActivity extends AppCompatActivity implements RecycleViewAdapter.ItemClickListener {

    RecycleViewAdapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        EventBus.getDefault().register(this);
        ApiServive.getNews(this);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsResponseRecieved(NewsResponse response){
            adapter = new RecycleViewAdapter(this,response.getArticles(),this );

            recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Article article) {
         Intent intent = new Intent(this, SecondActivity.class);
         intent.putExtra("Title",article.getTitle());
         intent.putExtra("Description",article.getDescription());
//         intent.putExtra("Url",article.getUrl());
        startActivity(intent);
    }
}