package com.example.musicalstructure.models;

import java.util.List;

/**
 * this class represent a genre entity
 */
public class Genre extends Data {
    // we can add more field in case we need.
    public Genre(List<Song> songs, String name) {
        super(songs, name);
    }
}
