package com.example.musicalstructure.models;

import java.util.List;

/**
 * this class represent a playlist entity
 */
public class Playlist extends Data {
    // we can add more field in case we need.
    public Playlist(List<Song> songs, String name) {
        super(songs, name);
    }
}
