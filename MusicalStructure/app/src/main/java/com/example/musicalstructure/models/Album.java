package com.example.musicalstructure.models;

import java.util.List;

/**
 * this class represent a album entity
 */
public class Album extends Data {
    // we can add more field in case we need.
    public Album(int image, List<Song> songs, String name) {
        super(image, songs, name);
    }
}
