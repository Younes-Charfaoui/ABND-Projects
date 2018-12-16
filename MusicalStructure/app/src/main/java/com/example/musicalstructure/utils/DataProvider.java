package com.example.musicalstructure.utils;

import com.example.musicalstructure.activities.MusicActivity;
import com.example.musicalstructure.models.Data;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    private static List<Data> albumList;
    private static List<Data> artistList;
    private static List<Data> genreList;
    private static List<Data> playList;

    static {
        albumList = new ArrayList<>();
        artistList = new ArrayList<>();
        genreList = new ArrayList<>();
        playList = new ArrayList<>();
    }

    public static List<Data> getData(int type) {
        switch (type) {
            case MusicActivity.TYPE_ARTIST:
                return artistList;
            case MusicActivity.TYPE_PLAYLIST:
                return playList;
            case MusicActivity.TYPE_GENRE:
                return genreList;
            case MusicActivity.TYPE_ALBUM:
                return albumList;
            default:
                return albumList;
        }
    }
}
