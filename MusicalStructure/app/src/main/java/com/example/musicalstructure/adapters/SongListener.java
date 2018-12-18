package com.example.musicalstructure.adapters;

import com.example.musicalstructure.models.Song;

public interface SongListener {

    /**
     * notify the activity by the listener that song has been clicked at a given position
     * @param song clicked
     */
    void onSongClicked(Song song);
}
