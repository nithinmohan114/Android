package com.example.nithin.newsapp;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nithin on 15/3/18.
 */

public interface Apis {

    @GET("v2/top-headlines")
    Call<NewsResponse> getNews(@Query("apiKey") String apiKey,@Query("country")String country);

    @GET("v2/everything")
    Call<NewsResponse> getArticle(@Query("apiKey") String apiKey);
}
