package com.example.nithin.newsapp;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nithin on 15/3/18.
 */

public class ApiServive extends IntentService {


    public ApiServive() {
        super("ApiServive");
    }

    public static void getNews(Context context) {

        Intent newsIntent = new Intent(context, ApiServive.class);
        context.startService(newsIntent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        fetchNews();
    }

    private void fetchNews() {

        Apis apiInterface = ApiClient.getClient().create(Apis.class);

        Call<NewsResponse> call = apiInterface.getNews(Constants.apiKey, "us");

        try {
            call.enqueue(new Callback<NewsResponse>() {
                @Override
                public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                    EventBus.getDefault().post(response.body());
                }

                @Override
                public void onFailure(Call<NewsResponse> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
