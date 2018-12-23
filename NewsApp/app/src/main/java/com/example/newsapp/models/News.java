package com.example.newsapp.models;


import java.net.URL;


public class News {

    private String title;
    private String author;
    private String url;
    private String imageUrl;
    private String date;
    private String section;

    public News(String title, String author, String url, String imageUrl, String date, String section) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.imageUrl = imageUrl;
        this.date = date;
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
