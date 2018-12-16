package com.example.musicalstructure.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.artist);
        dest.writeString(this.album);
        dest.writeString(this.length);
        dest.writeInt(this.imageResource);
    }

    protected Song(Parcel in) {
        this.name = in.readString();
        this.artist = in.readString();
        this.album = in.readString();
        this.length = in.readString();
        this.imageResource = in.readInt();
    }

    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel source) {
            return new Song(source);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}
