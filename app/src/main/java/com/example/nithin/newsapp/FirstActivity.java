package com.example.nithin.newsapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class FirstActivity extends AppCompatActivity {

    Button btnWelcome;
    TextView tvMessage;
    EditText editText;
    CountingIdlingResource idlingResource =  new CountingIdlingResource("DATA_LOADER");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnWelcome = findViewById(R.id.button);
        tvMessage = findViewById(R.id.welcome);
        editText = findViewById(R.id.edittext);

        idlingResource.increment();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ((EditText)findViewById(R.id.edittext)).setText(R.string.app_name);
                            idlingResource.decrement();
                        }
                    });
            }
        }).start();


        btnWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, DogActivity.class);
                startActivity(intent);
            }
        });
    }

    public CountingIdlingResource getIdlingResource() {
        return idlingResource;
    }

    public void setIdlingResource(CountingIdlingResource idlingResource) {
        this.idlingResource = idlingResource;
    }
}

