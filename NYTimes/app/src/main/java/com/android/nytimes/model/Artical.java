package com.android.nytimes.model;

import java.util.Observable;

/**
 * Created by sathish on 21-02-2018.
 */

public class Artical extends Observable {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String byline) {
        this.author = byline;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String title;
    private String published_date;
    private String author;
    private String url;

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    private String imageurl;
}
