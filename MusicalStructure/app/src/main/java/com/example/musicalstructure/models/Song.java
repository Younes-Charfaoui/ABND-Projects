package com.example.musicalstructure.models;

public class Song {

    private String name;
    private String artist;
    private String album;
    private String length;
    private int imageResource;

    public Song(String name, String artist, String album, String length, int imageResource) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.length = length;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
