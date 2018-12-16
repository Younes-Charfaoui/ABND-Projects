package com.example.musicalstructure.models;

import java.util.List;

public class Playlist extends Data {

    Playlist(List<Song> songs, String name) {
        super(songs, name);
    }
}
