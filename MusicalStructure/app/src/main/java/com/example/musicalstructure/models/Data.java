package com.example.musicalstructure.models;

import java.util.List;

public class Data {

    private int image;
    private String name;
    private List<Song> songs;

    Data(int image, List<Song> songs, String name) {
        this.image = image;
        this.songs = songs;
        this.name = name;
    }

    Data(List<Song> songs, String name) {
        this.songs = songs;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
