package com.example.newsapp.models;


import java.net.URL;


public class News {

    private String title;
    private String author;
    private URL url;
    private URL imageUrl;
    private String date;
    private String section;

    public News(String title, String author, URL url, URL imageUrl, String date, String section) {
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

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public URL getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(URL imageUrl) {
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
