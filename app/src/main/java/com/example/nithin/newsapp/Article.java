package com.example.nithin.newsapp;

import com.google.gson.annotations.SerializedName;

public class Article {

    @SerializedName("title")
    String title;

    @SerializedName("description")
    String description;

//    @SerializedName("url")
//    String url;

    Source source;

//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
