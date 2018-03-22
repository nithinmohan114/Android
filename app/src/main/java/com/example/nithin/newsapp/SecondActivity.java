package com.example.nithin.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
//    TextView url;
    RecycleViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EventBus.getDefault().register(this);
        ApiServive.getNews(this);

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsDescriptionRecieved(NewsResponse response) {
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("Title");
        String message2 = bundle.getString("Description");
//        String message3 = bundle.getString("Url");
        textView1 = findViewById(R.id.textview);
        textView1.setText(message);
        textView2 =findViewById(R.id.textview2);
        textView2.setText(message2);
//        url = findViewById(R.id.url);
//        url.setText(message3);
    }
}
