package com.example.nithin.newsapp;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.eventbus.Subscribe;

import retrofit2.Response;

/**
 * Created by nithin on 15/3/18.
 */

public class NewsResponse  {

    @SerializedName("status")
     String status;

    @SerializedName("totalResults")
     int totalResults;


    @SerializedName("articles")
    Article[] articles;




    public Article[] getArticles() { return articles;}

    public void setArticles(Article[] articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

}

