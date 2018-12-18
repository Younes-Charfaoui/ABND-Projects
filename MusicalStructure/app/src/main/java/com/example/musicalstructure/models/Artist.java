package com.example.musicalstructure.models;

import java.util.List;

/**
 * this class represent an artist entity
 */
public class Artist extends Data {
    // we can add more field in case we need.
    public Artist(int image, List<Song> songs, String name) {
        super(image, songs, name);
    }
}
